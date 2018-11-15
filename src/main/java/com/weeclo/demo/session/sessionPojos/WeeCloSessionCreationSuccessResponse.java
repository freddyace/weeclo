package com.weeclo.demo.session.sessionPojos;

public class WeeCloSessionCreationSuccessResponse {
    String message = "Weeclo Session creation successful.";
    Long successTime = System.currentTimeMillis();

    public WeeCloSessionCreationSuccessResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Long successTime) {
        this.successTime = successTime;
    }

}
