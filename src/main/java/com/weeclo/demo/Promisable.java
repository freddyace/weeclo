package com.weeclo.demo;

import com.weeclo.demo.entities.UserEntity;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface Promisable {

    ResponseEntity createWeeCloUser(UserEntity userEntity);
    ResponseEntity login(HttpServletRequest httpServletRequest, String email, String password);
}
