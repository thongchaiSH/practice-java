package com.learn.java;

public class Hello {

    public static void main(String[] args) {
        Hello hello=new Hello();
        String result=hello.sayHi("Thongchai");
        System.out.println(result);
    }

    private String sayHi(String name) {
        return  "Hello "+name;
    }
}
