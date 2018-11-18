package com.weeclo.demo.response;

public class WeeCloSessionCreationSuccessResponse {
    private String message = "Weeclo Session creation successful.";
    private Long successTime;

    public WeeCloSessionCreationSuccessResponse(){
        this.successTime = System.currentTimeMillis();
    }

    public String getMessage() {
        return this.message;
    }

    public Long getSuccessTime() {
        return this.successTime;
    }


}
