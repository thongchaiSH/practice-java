package com.learn.java.optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {

    //orElse
    public static String optionOrElse(){
//       Optional<Student> student= Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> student= Optional.ofNullable(null);
       String name=student.map(Student::getName).orElse("Default");
       return name;
    }
    //orElseGet
    public static String optionalOrElseGet(){
//        Optional<Student> student= Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> student= Optional.ofNullable(null);
        String name=student.map(Student::getName).orElseGet(()->"Default");
        return name;
    }
    //orElseThrow
    public static String optionalOrElseThrow() {
//        Optional<Student> student= Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> student= Optional.ofNullable(null);
        String name=student.map(Student::getName)
                .orElseThrow(
                        ()->new RuntimeException("No data available")
                );
        return name;
    }

    public static void main(String[] args) {
        System.out.println("orElse : "+optionOrElse());
        System.out.println("orElseGet : "+optionalOrElseGet());
        System.out.println("orElseThrow : "+optionalOrElseThrow());
    }
}
