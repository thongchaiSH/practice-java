package com.learn.java.functioninterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {
    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    public static void filterStudentsByGraderLevel(){
        System.out.println("filterStudentsByGraderLevel :");
        List<Student> studentList=StudentDataBase.getAllStudents();

        studentList.forEach((student)->{
            if(p1.test(student)){
                System.out.println(student);
            }
        });
    }
    public static void filterStudentsByGpa(){
        System.out.println("filterStudentsByGpa :");
        List<Student> studentList=StudentDataBase.getAllStudents();

        studentList.forEach((student)->{
            if(p2.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudents(){
        System.out.println("filterStudents :");
        List<Student> studentList=StudentDataBase.getAllStudents();

        studentList.forEach((student)->{
            if(p1.and(p2).test(student)){
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        filterStudentsByGraderLevel();
        filterStudentsByGpa();
        filterStudents();
    }
}
