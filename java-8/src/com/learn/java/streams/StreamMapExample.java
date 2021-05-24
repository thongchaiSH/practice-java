package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {

    public static List<String> nameList() {
        return StudentDataBase.getAllStudents().stream()
                //input student -> student name
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) //Stream<String> -> uppercase operation on each input
                .collect(Collectors.toList());
    }

    public static Set<String> nameSet() {
        return StudentDataBase.getAllStudents().stream()
                //input student -> student name
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) //Stream<String> -> uppercase operation on each input
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) {
        System.out.println(nameList());
        System.out.println(nameSet());
    }
}
