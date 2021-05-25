package com.learn.java.parallelstream;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample1 {

    public static List<String> sequentialPrintStudentActivities() {
        long startTime = System.currentTimeMillis();
        List<String> result= StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //unique operation
                .sorted() //sort
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline is sequential : "+(endTime - startTime));
        return  result;
    }
    public static List<String> parallelPrintStudentActivities() {
        long startTime = System.currentTimeMillis();
        List<String> result= StudentDataBase.getAllStudents().stream() //Stream<Student>
                .parallel()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //unique operation
                .sorted() //sort
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline is parallel : "+(endTime - startTime));
        return  result;
    }


    public static void main(String[] args) {
        sequentialPrintStudentActivities();
        parallelPrintStudentActivities();
    }
}
