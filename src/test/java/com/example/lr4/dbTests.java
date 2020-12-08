package com.example.lr4;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class dbTests {
    @Autowired
    private MockMvc mockMvc;

    private static final Logger log = LoggerFactory.getLogger(Lr4ApplicationTests.class);

    @Test
    public void dbLogout() throws Exception {
        String userName1 = "logoutTest1";
        String userName2 = "logoutTest2";
        MvcResult result = mockMvc.perform(post("/chat/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", userName1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        result = mockMvc.perform(post("/chat/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", userName2))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        result = mockMvc.perform(post("/chat/logout")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", userName1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        result = mockMvc.perform(get("/chat/online"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(userName2)))
                .andReturn();
    }
}
