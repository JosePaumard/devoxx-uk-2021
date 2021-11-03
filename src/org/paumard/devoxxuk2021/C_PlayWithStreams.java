package org.paumard.devoxxuk2021;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class C_PlayWithStreams {

    public static void main(String[] args) {

//        var listOf =
//                List.of("one", "two", "three", "four", "five");
//
//        var list = new ArrayList<String>();
//
//        var count = listOf.stream()
//                .skip(2)
//                .limit(2)
//                .filter(s -> true)
//                .map(s -> {
//                    list.add(s);
//                    return s.toUpperCase();
//                })
//                .count();
//        System.out.println("count = " + count);
//        System.out.println("list = " + list);


        String ints = """
                1
                2
                3
                4
                # I have something add
                5
                """;

        List<Integer> toList =
        ints.lines()
//                .filter(
//                        s -> {
//                            try {
//                                Integer.parseInt(s);
//                                return true;
//                            } catch (NumberFormatException e) {
//                                return false;
//                            }
//                        }
//                )
//                .map(Integer::parseInt)
//                .flatMap(
//                        s -> {
//                            try {
//                                return Stream.of(Integer.parseInt(s));
//                            } catch (NumberFormatException e) {
//                                return Stream.of();
//                            }
//                        }
//                )
                .<Integer>mapMulti(
                        (s, stream) -> {
                            try {
                                stream.accept(Integer.parseInt(s));
                            } catch (NumberFormatException e) {

                            }
                        }
                )
                .toList();

        System.out.println("toList = " + toList);
    }
}