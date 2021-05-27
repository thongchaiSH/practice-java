package com.learn.java.defaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> integerList = Arrays.asList(1, 3, 4, 5);
        System.out.println("Result is : "+multiplier.multiply(integerList));
        System.out.println("Result size is : "+multiplier.size(integerList));

        System.out.println("static method is empty : "+Multiplier.isEmpty(integerList));

    }

}
