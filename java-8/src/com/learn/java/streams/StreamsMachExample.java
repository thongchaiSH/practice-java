package com.learn.java.streams;

import com.learn.java.data.StudentDataBase;

public class StreamsMachExample {

    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() >= 3.5);
    }


    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() >= 3.9);
    }

    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() >= 3.9);
    }



    public static void main(String[] args) {
        System.out.println("Result of all Match : "+allMatch());

        System.out.println("Result of any Match : "+anyMatch());

        System.out.println("Result of none Match : "+noneMatch());
    }
}
