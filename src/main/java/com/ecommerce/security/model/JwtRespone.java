package com.ecommerce.security.model;

public class JwtRespone {
    private String token;
    private String duration;

    public JwtRespone() {
    }

    public JwtRespone(String token, String duration) {
        this.token = token;
        this.duration = duration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
