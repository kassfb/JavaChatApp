package com.example.lr4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import com.example.lr4.models.Message;
import com.example.lr4.models.User;
import com.example.lr4.models.UserRepository;
import com.example.lr4.models.MessageRepository;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lr4Application {
	private static final Logger log = LoggerFactory.getLogger(Lr4Application.class);
	// Смотреть:
 // https://spring.io/guides/gs/accessing-data-jpa/
	// https://github.com/spring-guides/gs-accessing-data-jpa
	public static void main(String[] args) throws NullPointerException {

		SpringApplication.run(Lr4Application.class, args);
		//databaseTest();
	}

//	@Bean
//	public CommandLineRunner demo (UserRepository repository) {
//		return (args) -> {
//			repository.save(new User("vova","4321"));
//			repository.save(new User("sasha","1234"));
//			repository.save(new User("petya","qwerty"));
//			log.info("Users found with findAll():");
//			log.info("-------------------------------");
//			for (User user : repository.findAll()){
//				log.info(user.toString());
//			}
//			log.info("");
//
//			User user = repository.findById(1L);
//			log.info("User found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(user.toString());
//			log.info("");
//
//			log.info("User found with findByUserName('sasha'):");
//			log.info("--------------------------------------------");
//			repository.findByUserName("sasha").forEach(sasha -> {
//				log.info(sasha.toString());
//			});
//			log.info("");
//		};
//	}

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