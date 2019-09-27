package com.cruat.oauth.feature.users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	public static final String USER = "user@cruat.com";
	public static final String PASS = "pswrd";
	public static final String UUID = "739eae4f-33da-4760-8931-6a8a809c7e24";
	
	@Mock
	UserService userService;
	
	@InjectMocks
	UserController controller;
	
	MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void ping_noParams_ping() throws Exception {
		RequestBuilder get = MockMvcRequestBuilders.get("/ping");
		ResultActions result = mvc.perform(get);
		
		result.andExpect(MockMvcResultMatchers.status().isOk());
		result.andExpect(MockMvcResultMatchers.content().string("ping"));
	}
	
}
