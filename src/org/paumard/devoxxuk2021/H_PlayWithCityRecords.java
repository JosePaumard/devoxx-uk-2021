package org.paumard.devoxxuk2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class H_PlayWithCityRecords {

    record City(int id, String name, State state, int population, double surface) {

        public static City of(String line) {

            // 1;New York;New York;8 336 817;780,9
            var elements = line.split(";");
            var id = Integer.parseInt(elements[0]);
            var name = elements[1];
            var state = new State(elements[2]);
            var population = Integer.parseInt(elements[3].replaceAll(" ", ""));
            var surface = Double.parseDouble(elements[4].replaceAll("[ ,]", ""));
            return new City(id, name, state, population, surface);
        }
    }

    record State(String name) {

    }

    record PopulationState(State state, int population) {

        PopulationState(Map.Entry<State, Integer> entry) {
            this(entry.getKey(), entry.getValue());
        }

        public static Comparator<? super PopulationState> comparingByPopulation() {
            return Comparator.comparing(PopulationState::population);
        }
    }

    public static void main(String[] args) throws IOException {
        var main = new H_PlayWithCityRecords();
        main.run();
    }


    public void run() throws IOException {
        var path = Path.of("files/cities.csv");

        var cities = readCities(path);
        System.out.println("cities.size() = " + cities.size());

        // Read all states
        var states =
                cities.stream()
                        .map(City::state)
                        .distinct()
                        .toList();
        System.out.println("states.size() = " + states.size());

        // Population by state
        Map<State, Integer> populationByState =
                cities.stream()
                        .collect(
                                groupingBy(
                                        City::state, summingInt(City::population)
                                )
                        );

        // Most populated state
        var mostPopulatedState =
                populationByState.entrySet().stream()
                        .map(PopulationState::new)
                        .max(PopulationState.comparingByPopulation())
                        .orElseThrow();
        System.out.println("mostPopulatedState = " + mostPopulatedState);
    }

    private List<City> readCities(Path path) throws IOException {
        try (var lines = Files.lines(path);) {

            return lines.skip(2)
                    .map(City::of)
                    .toList();
        }
    }
}
