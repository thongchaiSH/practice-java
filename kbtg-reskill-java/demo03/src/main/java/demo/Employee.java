package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Employee {
    // 1. properties
    private int id;
    private String name;
    private double salary;
    private Date birthDate;
    // Constructor
    public Employee(){
        this(new Date(System.currentTimeMillis()));
    }
    public Employee(Date date){
        this.birthDate=date;
    }

    // 3. method
    public Integer calculateAge(){
        int  age=0;
        LocalDate dateBirthDate= LocalDate.ofInstant(this.birthDate.toInstant(), ZoneId.systemDefault());
        LocalDate localDate=LocalDate.now();
        Period period=Period.between(dateBirthDate,localDate);
        age=period.getYears();
        return  age;
    }

    //setter/getter

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
