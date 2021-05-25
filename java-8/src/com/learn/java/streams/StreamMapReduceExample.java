package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int noOfNoteBooks(){
       int noOfNoteBoos= StudentDataBase.getAllStudents().stream()  //steam<student>
                .filter((student -> student.getGpa()>=3.5))
               .filter((student -> student.getGender().equals("female")))
                .map(Student::getNoteBooks)         //steam<integer>
//                .reduce(0,(a,b)->a+b);
                .reduce(0,Integer::sum);

       return  noOfNoteBoos;
    }
    public static void main(String[] args) {
        System.out.println("noOfNoteBoos : "+noOfNoteBooks());
    }
}
