package com.weeclo.demo.RestCalls;

import com.weeclo.demo.exceptions.IncorrectRequestMethodException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class WeeCloRestCall {
    RestTemplate restTemplate;
    HttpHeaders httpHeaders;
    String response;
    String endpoint;
    HttpEntity<String> httpEntity;
    RequestMethod requestMethod;

    public WeeCloRestCall(String endpoint, RequestMethod requestMethod){
        this.requestMethod = requestMethod;
        this.restTemplate = new RestTemplate();
        this.endpoint = endpoint;
        this.httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    public void withJsonBody(JSONObject jsonObject){
        this.httpEntity = new HttpEntity<String>(jsonObject.toString(), this.httpHeaders);
    }
    public void executePost() throws Exception{
        if (!this.requestMethod.equals(RequestMethod.POST)) {
            this.response = this.restTemplate.postForObject(this.endpoint, this.httpEntity, String.class);
        }else{
            throw new IncorrectRequestMethodException();
        }
    }
    public void executeGet() throws Exception{
        if(!this.requestMethod.equals(RequestMethod.GET)) {
            this.response = this.restTemplate.getForObject(this.endpoint, String.class);
        }else{
            throw new IncorrectRequestMethodException();
        }
    }
}
