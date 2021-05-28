package com.learn.java.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateExample {

    public static void main(String[] args) {
        //LocalDate
        LocalDate localDate=LocalDate.now();
        System.out.println("LocalDate:"+localDate);
        //LocalTime
        LocalTime localTime=LocalTime.now();
        System.out.println("LocalTime:"+localDate);
        //LocalDateTime
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("LocalDateTime:"+localDateTime);
    }
}
