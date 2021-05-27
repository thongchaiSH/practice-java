package com.learn.java.optional;

import com.learn.java.data.Bike;
import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {
    //filter
    public static void optionalFilter() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .ifPresent(System.out::println);

    }

    //map
    public static void optionalMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        if (studentOptional.isPresent()) {
            studentOptional
                    .filter(student -> student.getGpa() >= 3.5)
                    .map(Student::getName)
                    .ifPresent(System.out::println);
        }

    }

    //flatmap
    public static void optionalFlatMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .flatMap(Student::getBike) //get map optional<Bike>
                .map(Bike::getName)
                .ifPresent(System.out::println);

    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }
}
