package com.epam.reflection.annotations;

import com.epam.reflection.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    String message() default "length is wrong";
    int min();
    int max();

    Class<?>[] groups() default {};

}
