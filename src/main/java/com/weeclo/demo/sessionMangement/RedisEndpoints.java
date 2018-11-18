package com.weeclo.demo.sessionMangement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

public class RedisEndpoints {


    public String POST_SESSION              = "http://localhost:8080/v1/post/session";
    public String GET_SESSION_BY_ID         = "http://localhost:8080/get/session/by/";
    public String GET_ALL_SESSIONS          = "http://localhost:8080/get/all/sessions";





}
