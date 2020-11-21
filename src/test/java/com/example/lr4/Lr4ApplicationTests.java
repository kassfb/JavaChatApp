package com.example.lr4;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class Lr4ApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(Lr4ApplicationTests.class);

	private static String MY_NAME_IN_CHAT = "I_AM_STUPID";
	private static String MY_MESSAGE_TO_CHAT = "KILL_ME_SOMEONE";

	@Test
	public void login() throws IOException {
		Response response = ChatClient.login(MY_NAME_IN_CHAT);
		log.info("[" + response + "]");
		String body = response.body().string();
		log.info(body);
		Assert.assertTrue(response.code() == 200 || body.equals("Already logged in:("));
	}

	@Test
	public void viewChat() throws IOException {
		Response response = ChatClient.viewChat();
		log.info("[" + response + "]");
		log.info(response.body().string());
		Assert.assertEquals(200, response.code());
	}

	@Test//TODO FIX
	public void viewOnline() throws IOException {
		Response response = ChatClient.viewOnline();
		log.info("[" + response + "]");
		log.info(response.body().toString());
		Assert.assertEquals(200, response.code());
	}

	@Test//TODO FIX
	public void say() throws IOException {
		Response response = ChatClient.say(MY_NAME_IN_CHAT, MY_MESSAGE_TO_CHAT);
		log.info("[" + response + "]");
		log.info(response.body().string());
		Assert.assertEquals(200, response.code());
	}

}
