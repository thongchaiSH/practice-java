package com.learn.java.numericstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 10) //intstream of 10 elemts
                //int
                .boxed()
                //Integer
                .collect(Collectors.toList());
    }

    public static int unBoxing(List<Integer> integers){
        //wrapper to primitive
       return integers.stream()
                //Wrapper Integer values
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Boxing : "+boxing());

        List<Integer> integerList=boxing();
        System.out.println("UnBoxing : "+unBoxing(integerList));
    }
}
