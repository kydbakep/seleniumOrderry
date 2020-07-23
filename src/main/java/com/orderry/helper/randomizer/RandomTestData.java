package com.orderry.helper.randomizer;

import com.github.javafaker.Faker;

public class RandomTestData {
    Faker faker = new Faker();

    public String getRandomEmail() {
        return String.format("%s_%s_%s@mail.com",
                faker.name().firstName().toLowerCase(),
                faker.lorem().characters(2).toLowerCase(),
                faker.name().lastName()).toLowerCase();
    }

    public String getRandomFirstName() {
        return String.format("%s", faker.name().firstName());
    }

    public String getRandomLastName() {
        return String.format("%s", faker.name().lastName());
    }

    public String getRandomCompany() {
        return String.format("%s", faker.commerce().department());
    }
}
