package com.learn.java.numericstream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {

    public static void main(String[] args) {
        IntStream intStream=IntStream.range(1,50);
        System.out.println(intStream.count());

        System.out.println("range");
        IntStream.range(1,50).forEach((value -> System.out.print(value+",")));
        System.out.println("rangeClosed");
        IntStream.rangeClosed(1,50).forEach((value -> System.out.print(value+",")));


        System.out.println("Long stream rang count : "+LongStream.rangeClosed(1,50).count());
        LongStream.rangeClosed(1,50).forEach((value -> System.out.print(value+",")));

        System.out.println("Double stream rang count : "+IntStream.rangeClosed(1,50).count());
        IntStream.rangeClosed(1,50).asDoubleStream().forEach((value -> System.out.print(value+",")));
    }
}
