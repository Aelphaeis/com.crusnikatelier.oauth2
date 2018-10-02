package com.cruat.oauth.feature.users;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	public static final String USER = "user@cruat.com";

	@Mock
	UserService userService;
	
	@InjectMocks
	UserController controller;
	
	private MockHttpServletRequestBuilder requestBuilder;
	private StandaloneMockMvcBuilder mvcBuilder;
	
	@Test
	public void createUser_user_registered() throws Exception {
		//build raw mocks
		
		//build request
		requestBuilder = MockMvcRequestBuilders.post("/users");
		requestBuilder.param("email", USER);
		requestBuilder.param("password", "password");
		
		//Build controller
		mvcBuilder = MockMvcBuilders.standaloneSetup(controller);
		MockMvc mvc = mvcBuilder.build();
		
		//run test
		ResultActions results = mvc.perform(requestBuilder);
		results.andExpect(status().isOk());
	}

}
