package com.th.annotation.model;

import com.th.annotation.annotation.BasicEngine;

@BasicEngine(mileage = "30",fuelType = "BioDiesel")
public class Car {
    String make;
    String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void getCarDetails(){
        System.out.println("Car Manufacturer: " + make);
        System.out.println("Car Model: " + model);
    }
}
