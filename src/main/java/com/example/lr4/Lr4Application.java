package com.example.lr4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.lr4.models.Messages;
import com.example.lr4.models.Users;

import java.sql.SQLException;
//throws SQLException // NullPointerException

@SpringBootApplication
public class Lr4Application {
	// Смотреть:
 // https://spring.io/guides/gs/accessing-data-jpa/
	// https://github.com/spring-guides/gs-accessing-data-jpa
	public static void main(String[] args) throws NullPointerException {

		SpringApplication.run(Lr4Application.class, args);
		//databaseTest();
	}

//	public static void databaseTest() {
//		UserService userService = new UserService();
//		Users user = new Users("Masha","myStrongPassword");
//		userService.saveUser(user);
//		Messages firstMessage = new Messages("myFirstMessage");//Exception!'org.hibernate.internal.util.config.ConfigurationException: Could not locate cfg.xml resource [hibernate.cfg.xml]
//		firstMessage.setUserId(user);
//		user.addMessage(firstMessage);
//		Messages secondMessage = new Messages("mySecondMessage");
//		secondMessage.setUserId(user);
//		user.addMessage(secondMessage);
//		userService.updateUser(user);
//	}
}