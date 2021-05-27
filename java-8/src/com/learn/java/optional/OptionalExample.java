package com.learn.java.optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    public static String getStudentName() {
        Student student = StudentDataBase.studentSupplier.get();
        if (student != null) {
            return student.getName();
        } else {
            return null;
        }
    }

    public static Optional<String> getStudentNameOptional() {
        Optional<Student> studentOptional= Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if (studentOptional.isPresent()) {
            return studentOptional.map(Student::getName);
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
//        String name=getStudentName();
//        System.out.println("Length of the student name : "+name);

        Optional<String> stringOptional=getStudentNameOptional();
        if(stringOptional.isPresent()){
            System.out.println("Length of the student name : "+stringOptional.get());
        }else{
            System.out.println("Name not found");
        }

    }

}
