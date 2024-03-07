package org.rest.hospitalAPI.models;

public class Patient {
    private String username;
    private String phoneNumber;

    public Patient(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}
