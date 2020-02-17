package com.epam.reflection;

import com.epam.reflection.exceptions.UnsuitableDiscountRateException;
import com.epam.reflection.exceptions.UnsuitableEmailException;
import com.epam.reflection.exceptions.UnsuitableLengthException;

import java.time.LocalDate;

public class RMain {
    public static void main(String[] args) throws IllegalAccessException, UnsuitableLengthException, UnsuitableEmailException, UnsuitableDiscountRateException {
        CustomerDto customerDto = new CustomerDto("qqq", "vl@mail.ru", LocalDate.of(2009,12,31),15);
        Validator.validate(customerDto);

    }
}
