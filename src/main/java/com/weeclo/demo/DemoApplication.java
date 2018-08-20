package com.weeclo.demo;

import com.sendgrid.*;
import com.weeclo.demo.entities.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(DemoApplication.class, args);
		UserEntity userEntity = new UserEntity();
		userEntity.setAddress1("1 Elm Street");
		userEntity.setAddress2("NULL");
		userEntity.setCity("Jonesboro");
		userEntity.setDateJoined(new Timestamp(System.currentTimeMillis()));
		userEntity.setDateOfBirth(new Date(System.currentTimeMillis()));
		userEntity.setEmailAddress("freddyace1993@gmail.com");
		//userEntity.setSt

		Email from = new Email("TeamWeeClo@weeclo.com");
		String subject = "Welcome to WeeClo!";
		Email to = new Email("freddyace1993@gmail.com");
		Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
		Mail mail = new Mail(from, subject, to, content);

//		SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		SendGrid sg= new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}

	}



