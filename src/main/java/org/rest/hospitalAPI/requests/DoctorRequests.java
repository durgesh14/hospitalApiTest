package org.rest.hospitalAPI.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.rest.hospitalAPI.models.Doctor;

public class DoctorRequests {
    public static Response registerDoctor(Doctor doctor){
        return  RestAssured.given()
                .contentType(ContentType.JSON)
                .body(doctor)
                .post("/doctors/register");
    }
    public static Response loginDoctor(Doctor doctor){
        return  RestAssured.given()
                .contentType(ContentType.JSON)
                .body(doctor)
                .post("/doctors/login");
    }
}
