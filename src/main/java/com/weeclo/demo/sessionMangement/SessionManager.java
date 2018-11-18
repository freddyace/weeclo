package com.weeclo.demo.sessionMangement;

import com.weeclo.demo.RestCalls.WeeCloRestCall;
import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.exceptions.IncorrectRequestMethodException;
import com.weeclo.demo.exceptions.NullObjectReceivedException;
import com.weeclo.demo.session.repository.WeeCloSessionRepositoryImpl;
import com.weeclo.demo.standardization.NullChecker;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class SessionManager {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    WeeCloSessionRepositoryImpl weeCloSessionRepository;
    public SessionManager(WeeCloSessionRepositoryImpl weeCloSessionRepository){
        this.weeCloSessionRepository = weeCloSessionRepository;
    }

    public boolean sessionExistsSearchByUserEntity(UserEntity userEntity){
        //===========Standardize input============================================
        try {
            NullChecker nullChecker = new NullChecker("sessionExistsSearchByUserEntity", 29, userEntity);
            nullChecker.performCheck();
            //===========Won't make it past here if it fails null check===============
            //Check if session exists
//            WeeCloRestCall weeCloRestCall = new WeeCloRestCall(RedisEndpoints.GET_SESSION_BY_ID+userEntity.getId(), RequestMethod.GET);
            WeeCloRestCall weeCloRestCall = new WeeCloRestCall("http://localhost:8080/get/session/by/"+userEntity.getId(), RequestMethod.GET);
            System.out.println("Enpoint hit: "+ "http://localhost:8080/get/session/by/"+userEntity.getId());
            JSONObject jsonObject = new JSONObject(userEntity);
            //===Executing the request================================================
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_PLAIN);
            weeCloRestCall.setHttpHeaders(httpHeaders);
            weeCloRestCall.executeGet();
            String response = weeCloRestCall.getResponse();
            if(response.contains("40401")){
                return false;
            }
            else{
                return true;
            }

        }catch(NullObjectReceivedException n){
            n.getMessage();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }

        return false;
    }

    public boolean sessionExistsSearchByToken(String token){
        //===========Standardize input============================================
        try {
            NullChecker nullChecker = new NullChecker("sessionExistsSearchByToken", 63, token);
            nullChecker.performCheck();
            //===========Won't make it past here if it fails null check===============
            //Check if session exists
//            WeeCloRestCall weeCloRestCall = new WeeCloRestCall(RedisEndpoints.GET_SESSION_BY_ID+userEntity.getId(), RequestMethod.GET);
            WeeCloRestCall weeCloRestCall = new WeeCloRestCall("http://localhost:8080/get/session/by/"+token, RequestMethod.GET);
            System.out.println("Enpoint hit: "+ "http://localhost:8080/get/session/by/"+token);
            //===Executing the request================================================
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.TEXT_PLAIN);
            weeCloRestCall.setHttpHeaders(httpHeaders);
            weeCloRestCall.executeGet();
            String response = weeCloRestCall.getResponse();
            if(response.contains("40401")){
                return false;
            }
            else{
                return true;
            }

        }catch(NullObjectReceivedException n){
            n.getMessage();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }

        return false;
    }


    public void save(UserEntity userEntity) {
        //Rest call
        WeeCloRestCall weeCloRestCall = new WeeCloRestCall("http://localhost:8080/v1/post/session", RequestMethod.POST);
        JSONObject jsonObject = new JSONObject(userEntity);
        try {
            weeCloRestCall.withJsonBody(jsonObject).executePost();
            System.out.println(weeCloRestCall.getResponse());
        }catch (IncorrectRequestMethodException i){
            System.out.println(i.getMessage());
        }catch (Exception e){
            System.out.println("Exception thrown of type: "+e.getClass());
            System.out.println(e.getMessage());
        }
    }

    public String retrieveSessionAsString(UserEntity userEntity){
        System.out.println("________"+new RedisEndpoints().GET_SESSION_BY_ID+userEntity.getId()+"____________");
        WeeCloRestCall weeCloRestCall = new WeeCloRestCall(new RedisEndpoints().GET_SESSION_BY_ID+userEntity.getId(), RequestMethod.GET);
        try {
            weeCloRestCall.executeGet();
            return weeCloRestCall.getResponse();
        }catch (Exception e){
            log.error(e.getMessage());
        }
            return weeCloRestCall.getResponse();
    }

    public String retrieveSessionAsStringByToken(String token){
        WeeCloRestCall weeCloRestCall = new WeeCloRestCall(new RedisEndpoints().GET_SESSION_BY_ID+token, RequestMethod.GET);
        try{
            weeCloRestCall.executeGet();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return weeCloRestCall.getResponse();
    }

}
