package com.weeclo.demo;

import com.weeclo.demo.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface Promisable {

    ResponseEntity createWeeCloUser(UserEntity userEntity);
    ResponseEntity login(String email, String password);
}
