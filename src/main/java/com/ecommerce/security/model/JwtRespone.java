package com.ecommerce.security.model;

public class JwtRespone {
    private String token;
    private String type;
    private String expires_in;

    public JwtRespone() {
    }

    public JwtRespone(String token, String type, String expires_in) {
        this.token = token;
        this.type = type;
        this.expires_in = expires_in;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
