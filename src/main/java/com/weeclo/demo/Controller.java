package com.weeclo.demo;


import com.weeclo.demo.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * Author: Freddy Acevedo @ WeeClo
 * last commit: 07/20/18
 */
@RestController
public class Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private Encryptor encryptor;

        private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        @PersistenceContext
        EntityManager em;


    /**
     *
     * @param weeCloUser
     * @return ResponseEntity
     *
     * Accepts a JSON representation of a WeeClo user from the UI, encrypts password, checks for
     * duplicate email addresses and returns a response body indicating the event that has occured
     * of type: String. Throws a persistence exception in the event where a JSON representation
     * of a WeeClo user being passed into this method contains a duplicate email address. Otherwise,
     * a generic exception is thrown.
     */
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

    /**
     *
     * @param email
     * @param password
     * @return ResponseEntity
     *
     * This method accepts values for email and password (credentials) from a URL via HTTP
     * and validates the user's credentials.
     * #TODO add logic to expect a hashed version of the credentials in the request. Should not expect raw password
     */
    @Transactional
    @RequestMapping(value="/login/credentials/", method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam(value = "email") String email, @RequestParam(value="password") String password){
        try{
            List<?> list = em.createQuery("select u from UserEntity u where u.emailAddress=?1")
                    .setParameter(1,email )
                    .getResultList();
            if(list.size()!=1){

                return new ResponseEntity<>("We've ran into a problem! Try again later.",HttpStatus.OK);
            }
            if(list.size()==1){
                UserEntity userEntity = (UserEntity) list.get(0);
                if(passwordEncoder.matches(password, userEntity.getPassword()))
                    return new ResponseEntity<>("Successfully validated user!", HttpStatus.OK);
                else
                    return new ResponseEntity<>("Wrong credentials!", HttpStatus.OK);

            }
        }catch (PersistenceException p ){
            p.printStackTrace();
        }
        return null;
    }

    //Add Token Authentication to this
    @Transactional
    @RequestMapping(value = "/userEmailExists", method = RequestMethod.GET)
    public ResponseEntity userEmailExists(@RequestBody String email){
           // em.createNativeQuery("SELECT * WHERE ");
            return null;
    }

    @Transactional
    @RequestMapping(value = "/passwordMatchesEmail", method = RequestMethod.GET)
    public ResponseEntity passwordMatchesEmail(@RequestBody String email){

        return null;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("/Users/freddyacevedo/IdeaProjects/Bars2018/src/main/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);

    }




}

