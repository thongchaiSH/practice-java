package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample {

    public static List<Student> filterStudents(){
       return StudentDataBase.getAllStudents().stream()     //Stream<Student>
                .filter((student -> student.getGender().equals("female"))) //Stream<Student>
               //filters and send only the students whose gender is female
               .filter((student -> student.getActivities().contains("gymnastics")))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("filterStudents : ");
        filterStudents().forEach(System.out::println);
    }
}
