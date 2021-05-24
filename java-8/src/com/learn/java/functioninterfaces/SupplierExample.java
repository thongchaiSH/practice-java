package com.learn.java.functioninterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Student>  studentSupplier=()->{
            return  new Student("Jenny",2,3.8,"female", 11, Arrays.asList("swimming", "gymnastics","soccer"));
        };

        Supplier<List<Student>> listSupplier=()->{
            return StudentDataBase.getAllStudents();
        };

        System.out.println("Student is : "+studentSupplier.get());
        System.out.println("Student list is : "+listSupplier.get());
    }
}
