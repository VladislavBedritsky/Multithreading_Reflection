package com.epam.reflection;

public class RMain {
    public static void main(String[] args) throws NoSuchFieldException {
        CustomerDto customerDto = new CustomerDto("1");


        Validator.validate(customerDto);
    }
}
