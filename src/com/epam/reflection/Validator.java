package com.epam.reflection;

import com.epam.reflection.annotations.*;
import com.epam.reflection.exceptions.UnsuitableDiscountRateException;
import com.epam.reflection.exceptions.UnsuitableEmailException;
import com.epam.reflection.exceptions.UnsuitableLengthException;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validate(Object object) throws IllegalAccessException, UnsuitableLengthException, UnsuitableEmailException, UnsuitableDiscountRateException {

        Class<?> clazz = object.getClass();


        for (Field field : clazz.getDeclaredFields()) {

            // @Length
            if (field.isAnnotationPresent(Length.class)){
                Length length = field.getAnnotation(Length.class);
                int variableSize = field.get(object).toString().toCharArray().length;

                if (variableSize < length.min() || variableSize > length.max()) {
                    throw new UnsuitableLengthException("Name must be between 2 and 30");
                } else {
                    System.out.println(field.get(object).toString()+": "+field.get(object).toString().toCharArray().length+" letter(s)");
                }
            }

            // @Email
            if(field.isAnnotationPresent(Email.class)) {
                Email email = field.getAnnotation(Email.class);

                Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
                Matcher matcher = pattern.matcher(field.get(object).toString());

                if (matcher.find()) {
                    System.out.println(field.get(object).toString());
                } else {
                    throw new UnsuitableEmailException();
                }
            }

            // @Adulthood
            if (field.isAnnotationPresent(AdultHood.class)) {
                AdultHood adultHood = field.getAnnotation(AdultHood.class);

                String getBirthDay = field.get(object).toString();

                LocalDate birthDay = LocalDate.parse(getBirthDay);
                LocalDate today = LocalDate.now();
                int age = Period.between(birthDay,today).getYears();

                if (age < adultHood.age()) {
                    System.out.println("Your age is - "+age+". You aren't adult.");
                } else {
                    System.out.println("Your age is - "+age+". You are adult.");
                }

            }

            // @Min @Max
            if (field.isAnnotationPresent(Min.class) && field.isAnnotationPresent(Max.class)) {
                Min min = field.getAnnotation(Min.class);
                Max max = field.getAnnotation(Max.class);

                int discountRate = Integer.parseInt(field.get(object).toString());

                if (discountRate < min.min() || discountRate > max.max()) {
                    throw new UnsuitableDiscountRateException();
                } else {
                    System.out.println("DiscountRate: "+discountRate);
                }
            }
        }


    }
}
