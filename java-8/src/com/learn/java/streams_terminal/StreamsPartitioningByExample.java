package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamsPartitioningByExample {


    public static void partitioningBy_1() {

        Predicate<Student> gpaPredicate = (student -> student.getGpa() >= 3.8);

        Map<Boolean, List<Student>> partitionMap = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(gpaPredicate));
        System.out.println("partitionMap :" + partitionMap);
    }

    public static void partitioningBy_2() {

        Predicate<Student> gpaPredicate = (student -> student.getGpa() >= 3.8);

        Map<Boolean, Set<Student>> partitionMap = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(gpaPredicate, toSet()));
        System.out.println("partitionMap :" + partitionMap);
    }

    public static void main(String[] args) {
//        partitioningBy_1();
        partitioningBy_2();
    }
}
