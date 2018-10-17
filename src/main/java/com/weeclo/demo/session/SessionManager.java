package com.weeclo.demo.session;

import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.repository.WeeCloSessionRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    WeeCloSessionRepositoryImpl weeCloSessionRepository;
    public SessionManager(WeeCloSessionRepositoryImpl weeCloSessionRepository){
        this.weeCloSessionRepository = weeCloSessionRepository;
    }

    public boolean sessionExists(UserEntity userEntity){
        try {
            if (weeCloSessionRepository.findById(Integer.toString(userEntity.getId())) == null) {
                return false;
            }
        }catch (NullPointerException e){
            log.error("No Session Object retrieved or object is null", e.getMessage());
        }
        return true;

    }

    public void save(WeeCloSession weeCloSession){
        weeCloSessionRepository.save(weeCloSession);
    }

}
