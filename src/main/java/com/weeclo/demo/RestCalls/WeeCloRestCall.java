package com.weeclo.demo.RestCalls;

import com.weeclo.demo.exceptions.IncorrectRequestMethodException;
import com.weeclo.demo.response.WeeCloSessionNotFoundResponse;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class WeeCloRestCall {
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private String response;
    private String endpoint;
    private HttpEntity<String> httpEntity;
    private RequestMethod requestMethod;

    public WeeCloRestCall(String endpoint, RequestMethod requestMethod){
        this.requestMethod = requestMethod;
        this.restTemplate = new RestTemplate();
        this.endpoint = endpoint;
        this.httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    public WeeCloRestCall withJsonBody(JSONObject jsonObject){
        this.httpEntity = new HttpEntity<String>(jsonObject.toString(), this.httpHeaders);
        return this;
        }

    public WeeCloRestCall withHttpHeaders(HttpHeaders httpHeaders){
        this.httpHeaders = httpHeaders;
        return this;
    }
    public void executePost() throws Exception{
        if (this.requestMethod==RequestMethod.POST) {
            this.response = this.restTemplate.postForObject(this.endpoint, this.httpEntity, String.class);
        }else{
            throw new IncorrectRequestMethodException();
        }
    }
    public void executeGet() throws Exception{
        if(this.httpEntity!=null){
            throw new Exception("Passing request body for request of type: GET");
        }
        if(this.requestMethod.equals(RequestMethod.GET)) {
            try {
                this.response = this.restTemplate.getForObject(this.endpoint, String.class);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            throw new IncorrectRequestMethodException();
        }
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
    public String getResponse() {
        return response;
    }
    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }
}
