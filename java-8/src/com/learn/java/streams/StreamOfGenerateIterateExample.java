package com.learn.java.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("adm", "dan", "julie");
        stringStream.forEach(System.out::println);

        System.out.println("Iterate");
        Stream.iterate(1, x -> x * 2)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("Generate");
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(10)
                .forEach(System.out::println);
    }

}
