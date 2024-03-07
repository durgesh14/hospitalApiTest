package org.rest.hospitalAPI.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final String BASE_URL = "https://hospitalapi-lflw.onrender.com";

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
