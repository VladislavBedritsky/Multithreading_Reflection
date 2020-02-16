package com.epam.reflection;

import com.epam.reflection.annotations.Length;

public class CustomerDto {

    @Length(min = 2,max = 30)
    public String name;

    public CustomerDto (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
