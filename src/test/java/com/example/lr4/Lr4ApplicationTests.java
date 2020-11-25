package com.example.lr4;

//import jdk.internal.jshell.tool.ConsoleIOContext;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.lr4.ChatClient;
import  com.example.lr4.ChatController;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Ignore;
//import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Lr4ApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	private static final Logger log = LoggerFactory.getLogger(Lr4ApplicationTests.class);

	private static String MY_NAME_IN_CHAT = "I_AM_STUPID";
	private static String MY_MESSAGE_TO_CHAT = "KILL_ME_SOMEONE";

	@Test
	public void login() throws Exception {
		MvcResult result = mockMvc.perform(post("/chat/login").content(MY_NAME_IN_CHAT))/*param("name=",MY_NAME_IN_CHAT))*/
				.andDo(print())
				.andExpect(status().isOk() /*|| (content().string(containsString("Already logged in:(")))*/)
						.andReturn();
	}

	//@Test
	//public void loginTry() throws Exception {
	//	MvcResult result = mockMvc.perform(SecurityMockMvcRequestBuilders.formLogin().user(MY_NAME_IN_CHAT))
	//			.andDo(print())
	//			.andExpect(status().isOk() /*|| (content().string(containsString("Already logged in:(")))*/)
	//			.andReturn();
	//}

	@Test
	public void viewChat() throws Exception {
		MvcResult result = mockMvc.perform(get("/chat/online"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void viewUserInChat() throws Exception {
		ChatClient.login(MY_NAME_IN_CHAT);
		MvcResult result = mockMvc.perform(get("/chat/online"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void viewUser() throws Exception {
		ChatController chatCTRL = new ChatController();
		chatCTRL.login(MY_NAME_IN_CHAT);
		MvcResult result = mockMvc.perform(get("/chat/online"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}
	/*
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
	*/

}
