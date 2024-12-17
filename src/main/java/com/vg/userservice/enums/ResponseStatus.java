package com.vg.userservice.enums;
public enum ResponseStatus {


    SUCCESS(1,"SUCCESS"),
    FAILURE(2,"FAILURE");
    private final int statusId;
    private final String statusMsg;


    private ResponseStatus(int statusId, String statusMsg) {
        this.statusId = statusId;
        this.statusMsg = statusMsg;
    }


    public int getStatusId() {
        return statusId;
    }
    public String getStatusMsg() {
        return statusMsg;
    }
    public static ResponseStatus valueOf(int statusId) {
        for (ResponseStatus responseStatus : values()) {
            if (responseStatus.statusId == statusId) {
                return responseStatus;
            }
        }
        return null;
    }
}

