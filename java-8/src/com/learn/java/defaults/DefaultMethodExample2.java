package com.learn.java.defaults;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {

    static Consumer<Student> studentConsumer = (student -> System.out.println(student));

    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa).reversed();
    static Comparator<Student> gradeComparator = Comparator.comparingDouble(Student::getGradeLevel);
    public static void sortByName(List<Student> studentList) {
        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortByGPA(List<Student> studentList) {

        studentList.sort(gpaComparator);
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining(List<Student> studentList) {
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        studentList.forEach(studentConsumer);
    }

    public static void sortWithNullValues(List<Student> studentList){
       Comparator<Student> studentComparator= Comparator.nullsFirst(nameComparator); //nul first/last
       studentList.sort(studentComparator);
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println(studentList);

        System.out.println("After sort !!");
//        sortByName(studentList);
//        sortByGPA(studentList);
//        comparatorChaining(studentList);
        sortWithNullValues(studentList);

    }
}
