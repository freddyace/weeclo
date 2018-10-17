package com.weeclo.demo;


import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.SessionManager;
import com.weeclo.demo.session.certificate.Certificate;
import com.weeclo.demo.session.WeeCloSession;
import com.weeclo.demo.session.repository.UserEntityRepository;
import com.weeclo.demo.session.repository.WeeCloSessionRepository;
import com.weeclo.demo.session.token.Token;
import org.json.JSONObject;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * Author: Freddy Acevedo @ WeeClo
 * last commit: 07/20/18
 */

@RestController
public class Controller {
    @Autowired
    SessionManager sessionManager;
    UserEntityRepository userEntityRepository;
    WeeCloSessionRepository weeCloSessionRepository;
    public Controller(UserEntityRepository userEntityRepository,
                      WeeCloSessionRepository weeCloSessionRepository){
        this.userEntityRepository = userEntityRepository;
        this.weeCloSessionRepository = weeCloSessionRepository;
    }


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
            //No Records exist
            if(list.size()!=1){
                return new ResponseEntity<>("Incorrect credentials",headers,HttpStatus.FORBIDDEN);
            }
            //1 record found. *Ideal Situation*
            if(list.size()==1){
                Object object = list.get(0);
                UserEntity userEntity = (UserEntity) object;
                if(sessionManager.sessionExists(userEntity)){

                }else if(passwordEncoder.matches(password, userEntity.getPassword())) {
                    Certificate certificate = new Certificate();
                    certificate.setToken(new Token());
                    certificate.setOwnerID((Integer.toString(userEntity.getId())));
                    certificate.setOwnerFirstName(userEntity.getFirstName());
                    certificate.setOwnerLastName(userEntity.getLastName());
                    certificate.setOwnerID(userEntity.getSystemName());
                    weeCloSession = new WeeCloSession(certificate);
                    weeCloSession.setLoggedIn(userEntity);
                    sessionManager.save(weeCloSession);
//                    weeCloSessionRepository.save(weeCloSession);
                        return new ResponseEntity<>("Successfully validated user! Assigned session token ID: " + weeCloSession.getCertificate().getToken().getID()
                                + "with headers: " + headers, headers, HttpStatus.OK);


                }
                ///*******************************//
                /*error/issue occured*/
                else
                    return new ResponseEntity<>("Incorrect credentials", headers,HttpStatus.FORBIDDEN);

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

//    @GetMapping("/add/{id}/{email}")
//    public UserEntity add(@PathVariable("id") final String id,
//                    @PathVariable("name") final String email) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1234);
//        userEntity.setSystemName("franksinatra");
//        userEntity.setFirstName("Frank");
//        userEntity.setLastName("Sinatra");
//        userEntity.setPassword("asdf");
//        userEntity.setPhone("2302565676");
//        userEntity.setAddress1("1 Elm Street");
//        userEntity.setAddress2("NULL");
//        userEntity.setCity("Buckhead");
//        userEntity.setStateId("GA");
//        userEntity.setZip(30303);
//        userEntity.setNeighborhood(1);
//        userEntity.setDateJoined(new Timestamp(System.currentTimeMillis()));
//        userEntity.setDateOfBirth(new Date(System.currentTimeMillis()));
//        userEntity.setEmailAddress(email);
//        userEntity.setStatus("Active");
//        userEntity.setProfilePictureName("Bootyhole");
//        userEntity.setProfilePicturePath("undefined");
//        JSONObject jsonObject = new JSONObject(userEntity);
//        System.out.println(jsonObject);
//        userEntityRepository.save(new UserEntity());
//        return userEntityRepository.findById(id);
//    }
@GetMapping("/add/{id}")
public UserEntity add(@PathVariable("id") String id) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(Integer.parseInt(id));
    userEntity.setSystemName("franksinatra");
    userEntity.setFirstName("Frank");
    userEntity.setLastName("Sinatra");
    userEntity.setPassword("asdf");
    userEntity.setPhone("2302565676");
    userEntity.setAddress1("1 Elm Street");
    userEntity.setAddress2("NULL");
    userEntity.setCity("Buckhead");
    userEntity.setStateId("GA");
    userEntity.setZip(30303);
    userEntity.setNeighborhood(1);
    userEntity.setDateJoined(new Timestamp(System.currentTimeMillis()));
    userEntity.setDateOfBirth(new Date(System.currentTimeMillis()));
    userEntity.setEmailAddress("junker@gmail.com");
    userEntity.setStatus("Active");
    userEntity.setProfilePictureName("Bootyhole");
    userEntity.setProfilePicturePath("undefined");
    JSONObject jsonObject = new JSONObject(userEntity);
    System.out.println(jsonObject);
    userEntityRepository.save(userEntity);
    return userEntityRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public UserEntity update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        userEntityRepository.update(new UserEntity());
        return userEntityRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<Integer, UserEntity> delete(@PathVariable("id") final String id) {
        userEntityRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<Integer, UserEntity> all() {
        return userEntityRepository.findAll();
    }

    @GetMapping("/session/add/")
    public Map<String, WeeCloSession> add(){
//        Certificate certificate = new Certificate();
//        certificate.setOwnerFirstName("Freddy");
//        certificate.setOwnerLastName("Acevedo");
//        certificate.setOwnerID("freddyace");
//        WeeCloSession weeCloSession = new WeeCloSession(certificate);
//
//        weeCloSessionRepository.save(weeCloSession);
//        JSONObject jsonObject = new JSONObject(weeCloSession);
//        System.out.println(jsonObject);
        return weeCloSessionRepository.findAll();
    }




}

