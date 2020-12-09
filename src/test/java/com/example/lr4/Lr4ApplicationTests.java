package com.example.lr4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.Test;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Disabled
public class Lr4ApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	private static final Logger log = LoggerFactory.getLogger(Lr4ApplicationTests.class);

	private static String MY_NAME_IN_CHAT = "I_AM_STUPID";
	private static String MY_MESSAGE_TO_CHAT = "KILL_ME_SOMEONE";

	@Test
	public void login() throws Exception {
		MvcResult result = mockMvc.perform(post("/chat/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("name",MY_NAME_IN_CHAT))
				.andDo(print())
				.andExpect(status().isOk())
						.andReturn();
	}

	@Test
	public void viewChat() throws Exception {
		MvcResult result = mockMvc.perform(get("/chat/online"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void viewUser() throws Exception {
		String userName ="viewUserTest";
		MvcResult result = mockMvc.perform(post("/chat/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("name",userName))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		result = mockMvc.perform(get("/chat/online"))
		.andDo(print())
		.andExpect(status().isOk())
				.andExpect(content().string(containsString(userName)))
		.andReturn();
	}

	@Test
	public void logout() throws Exception {
		String userName ="logoutTest";
		MvcResult result = mockMvc.perform(post("/chat/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("name",userName))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

				result = mockMvc.perform(post("/chat/logout")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
						.param("name",userName))
						.andDo(print())
						.andExpect(status().isOk())
						.andReturn();

		result = mockMvc.perform(get("/chat/online"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(""))
				.andReturn();
	}

	@Test
	public void sayTest() throws Exception {
		String userName ="sayTest";
		MvcResult result = mockMvc.perform(post("/chat/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("name", userName))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		result = mockMvc.perform(post("/chat/say")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("name", userName)
				.param("msg",MY_MESSAGE_TO_CHAT))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		result = mockMvc.perform(get("/chat/chat"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(MY_MESSAGE_TO_CHAT)))
				.andReturn();
	}
}
