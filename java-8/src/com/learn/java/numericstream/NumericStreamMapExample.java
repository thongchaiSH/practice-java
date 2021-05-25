package com.learn.java.numericstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    private static List<Integer> mapToObj() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj((i) -> {
                    return new Integer(i);
                })
                .collect(Collectors.toList());
    }

    public static long mapToLong(){
        return IntStream.rangeClosed(1,5)  //intStream
                .mapToLong((i)->i) //convert intStream to longStream
                .sum();
    }

    public static double mapToDouble(){
        return IntStream.rangeClosed(1,5)  //intStream
                .mapToDouble((i)->i) //convert intStream to doubleStream
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("mapToObj : "+mapToObj());

        System.out.println("mapToLong : "+mapToLong());

        System.out.println("mapToDouble : "+mapToDouble());
    }

}
