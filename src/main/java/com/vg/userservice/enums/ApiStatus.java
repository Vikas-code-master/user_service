package com.vg.userservice.enums;
public enum ApiStatus {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    private final int code;
    private final String message;


    ApiStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }
}
