package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMappingExample {
    public static void main(String[] args) {
        StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        List<String> nameList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        System.out.println("nameList : "+nameList);

        Set<String> nameSet = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));

        System.out.println("nameSet : "+nameSet);
    }
}
