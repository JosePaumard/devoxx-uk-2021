package org.paumard.devoxxuk2021;

import java.util.*;

public class B_PlayWithLists {

    public static void main(String[] args) {

        var arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");
        arrayList.add(null);


        var arraysAsList =
                Arrays.asList("one", "two", "three", "four", "five", null);
//        arraysAsList.replaceAll(String::toUpperCase);


        var listOf =
                List.of("one", "two", "three", "four", "five");

        System.out.println("arrayList    = " + arrayList);
        System.out.println("arraysAsList = " + arraysAsList);
        System.out.println("listOf       = " + listOf);

        arrayList.removeIf(Objects::isNull);
        var copyOf1 = List.copyOf(arrayList);
        System.out.println("copyOf1 = " + copyOf1);
        System.out.println("Equals = " + (arrayList == copyOf1));

        var copyOf2 = List.copyOf(listOf);
        System.out.println("Equals = " + (listOf == copyOf2));

        var map =
                Map.of(1, "1", 2, "2");
        var map2 =
                Map.ofEntries(Map.entry(1, "1"));
    }
}