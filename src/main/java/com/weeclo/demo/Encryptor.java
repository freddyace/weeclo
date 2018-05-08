package com.weeclo.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encryptor extends BCryptPasswordEncoder {

}
