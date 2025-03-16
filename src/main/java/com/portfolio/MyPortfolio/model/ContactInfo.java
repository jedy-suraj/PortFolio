package com.portfolio.MyPortfolio.model;

public class ContactInfo {
    private String name;
    private String email;
    private String message;

    public ContactInfo(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }
    public ContactInfo(){

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
