package com.learn.java.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class ComparingDatesPeriodExample {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 05, 27);
        LocalDate localDate1 = LocalDate.of(2021, 12, 31);

        /**
         *
         */
        Period period = localDate.until(localDate1);
        System.out.println("getDays:" + period.getDays());//return day - day 31-27
        System.out.println("getMonths:" + period.getMonths());//return 12-05
        System.out.println("getYears:" + period.getYears());//return 2021-2021

        Period period1 = Period.ofDays(10);
        System.out.println("period1:"+period1.getDays());

        Period period2 = Period.ofYears(10);
        System.out.println("getYears:"+period2.getYears());
        System.out.println("toTotalMonths:"+period2.toTotalMonths()); //total months in 10 years

        Period period3=Period.between(localDate,localDate1);
        System.out.println("period3 : "+period3.getDays() + " : "+period3.getMonths()+" : "+period3.getYears());

//        Period.between(LocalTime.now(),LocalTime.now().plusHours(24));
    }
}
