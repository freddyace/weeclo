package com.weeclo.demo;


import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.Certificate;
import com.weeclo.demo.session.WeeCloSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpHeaders;
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
import java.util.Properties;


/**
 * Author: Freddy Acevedo @ WeeClo
 * last commit: 07/20/18
 */
@RestController
public class Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

        WeeCloSession weeCloSession;
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
    //TODO:Handle other duplicate entry scenarios, ex: Different email, same username
    @Transactional
    @RequestMapping(value = "/createWeeCloUser", method = RequestMethod.POST)
    public ResponseEntity createWeeCloUser(@RequestBody UserEntity weeCloUser){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
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
                return new ResponseEntity<>("Success",responseHeaders, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("An account with this email already exists.", responseHeaders ,HttpStatus.NOT_ACCEPTABLE);
            }
        }
        catch(PersistenceException p){
            p.printStackTrace();
            return new ResponseEntity<>("An issue with the database occured. Try again later.",responseHeaders ,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("An issue has occured. We'll get to the bottom of it.",responseHeaders ,HttpStatus.INTERNAL_SERVER_ERROR);
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
    public ResponseEntity<String> login(@RequestParam(value = "email") String email, @RequestParam(value="password") String password){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        try{
            List<?> list = em.createQuery("select u from UserEntity u where u.emailAddress=?1")
                    .setParameter(1,email )
                    .getResultList();
            if(list.size()!=1){
                return new ResponseEntity<>("Incorrect credentials",headers,HttpStatus.FORBIDDEN);
            }
            if(list.size()==1){
                weeCloSession = new WeeCloSession(new Certificate());
                UserEntity userEntity = (UserEntity) list.get(0);
                if(passwordEncoder.matches(password, userEntity.getPassword())) {
                    return new ResponseEntity<>("Successfully validated user! Assigned session token ID: "+weeCloSession.getToken().getID()
                            +"with headers: "+headers, headers, HttpStatus.OK);

                }
                else
                    return new ResponseEntity<>("We've ran into a problem! Try again later.", headers,HttpStatus.OK);

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
        Resource resource = new ClassPathResource("");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        //properties.getProperty("images.directory");
        File convertFile = new File(properties.getProperty("images.directory")+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);

    }




}

