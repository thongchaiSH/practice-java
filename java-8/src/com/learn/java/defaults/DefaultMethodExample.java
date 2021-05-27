package com.learn.java.defaults;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultMethodExample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");

        /**
         * Prior Java8
         * */
//        Collections.sort(stringList);
        System.out.println("Sorted list using Collections.sort " + stringList);

        /**
        * Java 8
        * */
        stringList.sort(Comparator.naturalOrder());
        System.out.println("Sorted list using List.sort " + stringList);

        stringList.sort(Comparator.reverseOrder());
        System.out.println("Sorted list using List.sort revert " + stringList);

    }
}
