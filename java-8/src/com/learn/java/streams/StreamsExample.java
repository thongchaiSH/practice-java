package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> studentPredicate=(student -> student.getGradeLevel()>=3);
        Predicate<Student> studentGpaPredicate=(student -> student.getGpa()>=3.9);


        Map<String, List<String>> studentMap= StudentDataBase.getAllStudents().stream() //stream pipeline
                .peek((student -> { //debug stream
                    System.out.println("Debug : "+ student);
                }))
                .filter(studentPredicate)
                .peek((student -> { //debug stream
                    System.out.println("After 1 st filter : "+ student);
                }))
                .filter(studentGpaPredicate)
                .peek((student -> { //debug stream
                    System.out.println("After 2 nd filter : "+ student);
                }))
//                .filter((student -> student.getGradeLevel()>=3))
                .collect(Collectors.toMap(Student::getName,Student::getActivities));


        System.out.println(studentMap);
    }
}
