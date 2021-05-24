package com.learn.java.methodreference;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

//    static Consumer<Student> c1= p -> System.out.println(p);
    static Consumer<Student> c1= System.out::println;

    static Consumer<Student> c2=Student::printListOfActivities;

    public static void main(String[] args) {
//        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
    }
}
