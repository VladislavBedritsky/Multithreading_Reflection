package com.epam.reflection.annotations;

import com.epam.reflection.Validator;

import java.lang.annotation.*;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Length {

    int min();
    int max();



}
