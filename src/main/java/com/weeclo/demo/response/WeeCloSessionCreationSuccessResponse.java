package com.weeclo.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weeclo.demo.session.token.Token;

public class WeeCloSessionCreationSuccessResponse {
    @JsonProperty("message")
    private String message = "Weeclo Session creation successful.";
    @JsonProperty("successTime")
    private Long successTime;
    @JsonProperty("token")
    private Token token;

    public WeeCloSessionCreationSuccessResponse(){
        this.successTime = System.currentTimeMillis();
    }

    public WeeCloSessionCreationSuccessResponse(Token token){
        this.successTime = System.currentTimeMillis();
        this.token = token;
    }

    public String getMessage() {
        return this.message;
    }

    public Long getSuccessTime() {
        return this.successTime;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }


}
