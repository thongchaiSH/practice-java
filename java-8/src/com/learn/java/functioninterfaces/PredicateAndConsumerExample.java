package com.learn.java.functioninterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    static BiPredicate<Integer,Double> biPredicate=(gradeLevel,gpa)-> gradeLevel>=3  && gpa>=3.9;

    static BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    static Consumer<Student> studentConsumer = (student -> {
//        if (p1.and(p2).test(student)) {
        if (biPredicate.test(student.getGradeLevel(),student.getGpa())) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    public void printNameAndActivities(List<Student> students) {
        students.forEach(studentConsumer);
    }
    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new PredicateAndConsumerExample().printNameAndActivities(studentList);
    }




}
