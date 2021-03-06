package com.epam.reflection;

import com.epam.reflection.annotations.*;

import java.time.LocalDate;

public class CustomerDto {

    @Length(min = 2, max = 30)
    public String name;

    @Email
    public String email;

    @AdultHood
    public LocalDate birthday;

    @Min(min = 0)
    @Max(max = 100)
    public int discountRate;

    public CustomerDto (String name, String email, LocalDate birthday, int discountRate) {
        this.discountRate = discountRate;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

}
