package com.ecommerce.utils;

public class Error {
    private String status;
    private String message;

    public Error() {
    }

    public Error(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
