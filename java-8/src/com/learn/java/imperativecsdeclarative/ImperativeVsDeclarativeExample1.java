package com.learn.java.imperativecsdeclarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1 {
    public static void main(String[] args) {
        /*
        * Imperative - Hot style of programming
        * */
        int sum=0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println("Imperative : "+sum);

        /*
        * Declarative Style of programming - What's style of programming
        * */
        int sum1=IntStream.rangeClosed(0,100)
                .parallel()
                .sum();
        System.out.println("Declarative approach : "+sum1);
    }
}
