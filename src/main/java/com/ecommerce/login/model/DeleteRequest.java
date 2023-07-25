package com.ecommerce.login.model;

public class DeleteRequest {
    private String email;

    public DeleteRequest() {
    }

    public DeleteRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DeleteRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}
