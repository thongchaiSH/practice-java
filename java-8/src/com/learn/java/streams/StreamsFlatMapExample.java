package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {


    public static List<String> printStudentActivities() {
        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //unique operation
                .sorted() //sort
                .collect(Collectors.toList());
    }

    public static long getStudentActivitiesCount() {
        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //Stream<String> with unique operation
                .count();
    }

    public static void main(String[] args) {
        System.out.println("printStudentActivities : " + printStudentActivities());
        System.out.println("getStudentActivitiesCount : " + getStudentActivitiesCount());
    }

}
