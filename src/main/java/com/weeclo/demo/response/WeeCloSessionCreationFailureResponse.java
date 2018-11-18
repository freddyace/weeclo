package com.weeclo.demo.response;

public class WeeCloSessionCreationFailureResponse {

    String message ="Session creation failure. Failure caused by: ";
    long failureTime = System.currentTimeMillis();
    Exception exception;
    public WeeCloSessionCreationFailureResponse(Exception e){
        this.exception = e;
    }
    public String getMessage() {
        return message+exception.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Long failureTime) {
        this.failureTime = failureTime;
    }


}
