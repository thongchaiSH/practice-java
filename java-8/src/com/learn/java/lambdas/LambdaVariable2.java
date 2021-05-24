package com.learn.java.lambdas;

import java.util.function.Consumer;

public class LambdaVariable2 {
    static int value=4;


    public static void main(String[] args) {
//        int value=4; //local variable
        Consumer<Integer> c1=(i)->{
            value++;
            System.out.println(value+1);
        };

//        value=6;

        c1.accept(4);
    }
}
