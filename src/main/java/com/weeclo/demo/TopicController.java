package com.weeclo.demo;

import com.weeclo.demo.weeclo.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createWeeCloUser(@RequestBody UserEntity weeCloUser){
        try{
            List<?> results = em.createQuery("select id from UserEntity where emailAddress = ?")
                    .setParameter(1, weeCloUser.getEmailAddress())
                    .getResultList();
            if(results.size()==0) {
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
                return new ResponseEntity("Success", HttpStatus.OK);
            }
            else{
                return new ResponseEntity("An account with this email already exists.", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        catch(PersistenceException p){
            p.printStackTrace();
            return new ResponseEntity("An issue with the database occured. Try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("An issue has occured. We'll get to the bottom of it.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }






}

