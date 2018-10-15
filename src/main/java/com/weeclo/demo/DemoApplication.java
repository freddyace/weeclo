package com.weeclo.demo;

import com.weeclo.demo.entities.UserEntity;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;


@SpringBootApplication
public class DemoApplication {

//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory();
//	}
//
//	@Bean
//	RedisTemplate<String, UserEntity> redisTemplate() {
//		RedisTemplate<String, UserEntity> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//		return redisTemplate;
//	}
	public static void main(String[] args) throws IOException{
		SpringApplication.run(DemoApplication.class, args);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1234);
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
		userEntity.setEmailAddress("franksinatra@gmail.com");
		userEntity.setStatus("Active");
		userEntity.setProfilePictureName("Bootyhole");
		userEntity.setProfilePicturePath("undefined");
		JSONObject jsonObject = new JSONObject(userEntity);
		System.out.println(jsonObject);
//
//		Email from = new Email("TeamWeeClo@weeclo.com");
//		String subject = "Welcome to WeeClo!";
//		Email to = new Email("freddyace1993@gmail.com");
//		Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
//		Mail mail = new Mail(from, subject, to, content);
//
////		SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//		SendGrid sg= new SendGrid("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");
//		Request request = new Request();
//		try {
//			request.setMethod(Method.POST);
//			request.setEndpoint("mail/send");
//			request.setBody(mail.build());
//			Response response = sg.api(request);
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getBody());
//			System.out.println(response.getHeaders());
//		} catch (IOException ex) {
//			throw ex;
//		}
	}

	}



