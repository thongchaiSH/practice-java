package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamsGroupingByExample {

    public static void groupStudentByGender() {
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGender));

        System.out.println(studentMap);
    }


    public static void customizedGroupingBy() {
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_1() {
        Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")
                ));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_2() {
        Map<String, Integer> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName,
                        summingInt(Student::getNoteBooks)
                ));

        System.out.println(studentMap);
    }

    public static void threeArgumentGroupBy() {
        LinkedHashMap<String, Set<Student>> studentLinkedHashmap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));

        System.out.println(studentLinkedHashmap);
    }

    public static void calculateTopGpa() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        maxBy(Comparator.comparing(Student::getGpa))));

        System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa))
                                ,Optional::get)));

        System.out.println(studentMapOptional1);
    }

    public static void calculateLeastGpa() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        minBy(Comparator.comparing(Student::getGpa))));

        System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa))
                                ,Optional::get)));

        System.out.println(studentMapOptional1);
    }


    public static void main(String[] args) {
//        System.out.println("groupStudentByGender");
//        groupStudentByGender();
//        System.out.println("customizedGroupingBy");
//        customizedGroupingBy();
//        System.out.println("twoLevelGrouping_1");
//        twoLevelGrouping_1();
//        System.out.println("twoLevelGrouping_2");
//        twoLevelGrouping_2();
//        System.out.println("threeArgumentGroupBy");
//        threeArgumentGroupBy();
//        calculateTopGpa();
        calculateLeastGpa();
    }

}
