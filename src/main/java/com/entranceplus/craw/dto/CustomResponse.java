package com.entranceplus.craw.dto;

public class CustomResponse {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String message;
    private boolean success;
    private int status;

    @Override
    public String toString() {
        return "{\"message\":"+message+",\"success\":"+success+",\"status\":"+status+"}";
    }
}
