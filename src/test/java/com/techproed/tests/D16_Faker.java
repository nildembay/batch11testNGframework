package com.techproed.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class D16_Faker {
    @Test
    public void test() {
        Faker faker = new Faker();
        String isim = faker.internet().password();
        System.out.println(isim);

    }
}