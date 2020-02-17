package com.epam.reflection.exceptions;

public class UnsuitableLengthException extends Exception {

    private String text;

    public UnsuitableLengthException (String text) {
        this.text = text;
        System.out.println(text);
    }
}
