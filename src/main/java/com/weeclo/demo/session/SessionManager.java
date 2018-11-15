package com.weeclo.demo.session;

import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.repository.WeeCloSessionRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class SessionManager {
    @Value("${redis.host}")
    private String host;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    WeeCloSessionRepositoryImpl weeCloSessionRepository;
    public SessionManager(WeeCloSessionRepositoryImpl weeCloSessionRepository){
        this.weeCloSessionRepository = weeCloSessionRepository;
    }

    public boolean sessionExists(UserEntity userEntity){
        return false;

    }
    public String getHost(){
        return host;
    }


    public void save(WeeCloSession weeCloSession){
        weeCloSessionRepository.save(weeCloSession);
    }

}
