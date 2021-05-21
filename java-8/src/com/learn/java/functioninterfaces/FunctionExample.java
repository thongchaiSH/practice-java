package com.learn.java.functioninterfaces;

import java.util.function.Function;

    public class FunctionExample {

    static Function<String, String> function = (name) -> name.toUpperCase();

    static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("default");


    public static void main(String[] args) {
        System.out.println("Result : " + function.apply("thongchai"));

        System.out.println("Result of andthen : " + function.andThen(addSomeString).apply("thongchai"));

        System.out.println("Result of compose : " + function.compose(addSomeString).apply("thongchai"));
    }
}
