package org.rest.hospitalAPI.tests;


import io.restassured.response.Response;
import org.rest.hospitalAPI.models.Doctor;
import org.rest.hospitalAPI.requests.DoctorRequests;
import org.rest.hospitalAPI.utils.TestUtils;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DoctorTests extends BaseTest{
    private final Doctor doctor = TestUtils.generateDoctorData();
    private String authToken;

//    public void setUp(){
//        //Genearte a doc data
//        Response registerResponse = DoctorRequests.registerDoctor(doctor);
//        registerResponse.then().statusCode(200)
//                .body("message", equalTo("Doctor registered successfully"));
//
//        Response loginResponse = DoctorRequests.loginDoctor(doctor);
//        loginResponse.then().statusCode(200)
//                .body("token", notNullValue());
//        authToken = loginResponse.jsonPath().getString("token");
//
//    }
    @Test(priority = 0)
    public void testDoctorRegistrationSuccessful() {
        Response response = DoctorRequests.registerDoctor(doctor);

        response.then()
                .statusCode(201)
                .body("message", equalTo("Doctor registered successfully"));
    }
    @Test(priority = 1)
    public void testDoctorRegistrationFailed() {
        Doctor doctor = new Doctor("doc001", "doc001");
        Response response = DoctorRequests.registerDoctor(doctor);

        response.then()
                .statusCode(400)
                .body("error", equalTo("Doctor with this username already exists"));
    }

    @Test(priority = 2)
    public void testDoctorLoginSuccessful() {
        Response loginResponse = DoctorRequests.loginDoctor(doctor);
        loginResponse.then().statusCode(200)
                .body("token", notNullValue());
        authToken = loginResponse.jsonPath().getString("token");

    }
    @Test(priority = 3)
    public void testDoctorLoginFailed() {
        Doctor doctor = new Doctor("newdoctor", "wrongpassword");
        Response response = DoctorRequests.loginDoctor(doctor);

        response.then()
                .statusCode(401)
                .body("error", equalTo("Invalid username or password"));
    }
}
