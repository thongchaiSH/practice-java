package com.learn.java.numericstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {


    public static int sumOfNumbers(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum);
    }

    public static int sumOfNNumberIntStream() {
        return IntStream.rangeClosed(1, 6) //1,2,3,4,5,6
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("Sum of N numbers : " + sumOfNumbers(integers));

        System.out.println("sumOfNNumberIntStream : "+sumOfNNumberIntStream());

    }
}
