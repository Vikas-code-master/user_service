package com.vg.userservice.enums;

public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;


    public ApiResponse(ApiStatus status, T data) {
        this.statusCode = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }


    public ApiResponse(ApiStatus status) {
        this.statusCode = status.getCode();
        this.message = status.getMessage();
    }


    public int getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }
}

