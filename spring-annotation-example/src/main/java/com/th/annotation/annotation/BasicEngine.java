package com.th.annotation.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BasicEngine {
    String mileage() default "20";
    String fuelType() default "Gasoline";
}
