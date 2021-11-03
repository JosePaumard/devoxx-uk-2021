package org.paumard.devoxxuk2021;

public class A_PlayWithStrings {

    public static void main(String[] args) {
        int number = 10;
        String numbers = """
                        one      \s
                        "two"    \s
                        "three"  \s
                        "four"   \s
                        five     \s
                        $number  \s
                     """;

        System.out.println("numbers = " + numbers);
        numbers.lines()
                .map(s -> "|" + s + "|")
                .forEach(System.out::println);
    }
}