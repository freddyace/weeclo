package com.weeclo.demo;

import com.weeclo.demo.weeclo.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private Encryptor encryptor;

        private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        @PersistenceContext
        EntityManager em;

        @RequestMapping("/topics")
        public List<Topic> getAllTopics(){
            return Arrays.asList(
                    new Topic("spring", "Spring Framework", "Spring Framework Description"),
                    new Topic("java", "Core Java", "Core Java Description"),
                    new Topic("javascript", "JavaScript", "JavaScript Description")
            );
        }


    @Transactional
    @RequestMapping(value = "/createWeeCloUser", method = RequestMethod.POST)
    public String createWeeCloUser(@RequestBody UserEntity weeCloUser){
        try{
            weeCloUser.setPassword(passwordEncoder.encode(weeCloUser.getPassword()));
            em.persist(weeCloUser);
            em.flush();
            System.out.println("Input user password after encryption: "+ weeCloUser.getPassword());

            //Compare User input with encrypted
            if(passwordEncoder.matches("password", weeCloUser.getPassword())){
                System.out.println("True");
            }
            else{
                System.out.println("False");
            }
            return "Success";
        }
        catch(PersistenceException p){
            p.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Failure to create account";


    }





}

