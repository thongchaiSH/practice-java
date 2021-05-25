package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamsSumAvgExample {

    public static int sum() {
        return StudentDataBase.getAllStudents().stream()
                .collect(summingInt(Student::getNoteBooks));

//        return StudentDataBase.getAllStudents().stream().mapToInt(Student::getNoteBooks).sum();
    }

    public static double average() {
        return StudentDataBase.getAllStudents().stream()
                .collect(averagingInt(Student::getNoteBooks));

    }

    public static void main(String[] args) {
        System.out.println("Sum no of notebook: "+sum());
        System.out.println("average no of notebook : "+average());
    }
}
