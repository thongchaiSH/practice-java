package com.th.annotation.model;

import com.th.annotation.annotation.BasicEngine;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void annotation_test() {
        Car car = new Car("32", "Diesel");
        car.getCarDetails();
        Class carClass = car.getClass();
        System.out.println("========================================");
        Annotation testAnn = carClass.getAnnotation(BasicEngine.class);
        BasicEngine engine = (BasicEngine)testAnn;
        System.out.println("Mileage: " + engine.mileage());
        System.out.println("Fuel Type: " + engine.fuelType());
    }
}