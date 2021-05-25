package com.learn.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::max);
    }

    public static int findMinValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::min);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer::max);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer::min);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(16, 7, 8, 9, 10);
//        List<Integer> integerList = new ArrayList<>();

        System.out.println("findMaxValue : " + findMaxValue(integerList));

        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);
        System.out.println("Optional Max is : "+maxValueOptional);
        if(maxValueOptional.isPresent()){
            System.out.println("maxValueOptional : "+maxValueOptional.get());
        }else{
            System.out.println("No max value");
        }


        System.out.println("findMinValue : "+findMinValue(integerList));

        System.out.println("findMinValueOptional : "+findMinValueOptional(integerList).get() );
    }
}
