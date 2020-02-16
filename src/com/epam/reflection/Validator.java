package com.epam.reflection;

import com.epam.reflection.annotations.Length;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object object) throws NoSuchFieldException {
        Class<?> obj = object.getClass();
        Field field = obj.getField("name");
//        Length l = (Length) field.getAnnotatedType();
//        System.out.println(l.max());

        if (obj.isAnnotationPresent(Length.class)) {
            Annotation annotation = obj.getAnnotation(Length.class);
            Length length = (Length) annotation;
            System.out.println(length.min());
            System.out.println(length.max());
        }
    }
}
