package com.learn.java.functioninterfaces;

public class FunctionExample1 {
    public static String performString(String str){
       return FunctionExample.addSomeString.apply(str);
    }

    public static void main(String[] args) {
       String result= performString("Hello");
        System.out.println("Result :"+result);
    }
}
