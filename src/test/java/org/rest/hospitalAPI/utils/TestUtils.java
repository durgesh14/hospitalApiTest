package org.rest.hospitalAPI.utils;

import com.github.javafaker.Faker;
import org.rest.hospitalAPI.models.Doctor;

public class TestUtils {
    private static final Faker faker = new Faker();
    public static Doctor generateDoctorData() {
        String username = faker.internet().uuid().replace("-", "");
        String password = faker.internet().password();
        System.out.println("username"+ username + "and password: "+ password);
        return new Doctor(username, password);
    }
}
