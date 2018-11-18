package com.weeclo.demo.response;

public class WeeCloSessionNotFoundResponse {
    private String message = "WeeClo session not found";
    private long responseTime;

    public WeeCloSessionNotFoundResponse(){
        this.responseTime = System.currentTimeMillis();
    }


    public String getMessage() {
        return message;
    }

    public long getResponseTime() {
        return responseTime;
    }
}
