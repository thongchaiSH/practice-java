package com.learn.java.functioninterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudenExample {

    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach((student) -> {
            studentGradeMap.put(student.getName(), student.getGpa());
        });
        return studentGradeMap;
    });

    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
    }
}
