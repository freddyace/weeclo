package com.weeclo.demo;

import com.weeclo.demo.entities.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.Timestamp;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		UserEntity userEntity = new UserEntity();
		userEntity.setAddress1("1 Elm Street");
		userEntity.setAddress2("NULL");
		userEntity.setCity("Jonesboro");
		userEntity.setDateJoined(new Timestamp(System.currentTimeMillis()));
		userEntity.setDateOfBirth(new Date(System.currentTimeMillis()));
		userEntity.setEmailAddress("freddyace1993@gmail.com");
		//userEntity.setSt

	}


}
