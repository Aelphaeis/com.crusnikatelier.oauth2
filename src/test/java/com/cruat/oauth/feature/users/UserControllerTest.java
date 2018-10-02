package com.cruat.oauth.feature.users;

import static org.mockito.Mockito.when;
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
	
//	private static final Logger logger = LogManager.getLogger();
	public static final String USER = "user@cruat.com";
	public static final String PASS = "pswrd";
	public static final String UUID = "739eae4f-33da-4760-8931-6a8a809c7e24";

	@Mock
	UserService userService;
	
	@InjectMocks
	UserController controller;
	
	private MockHttpServletRequestBuilder requestBuilder;
	private StandaloneMockMvcBuilder mvcBuilder;
	

	
	@Test
	public void createUser_user_registered() throws Exception {
		//build raw mocks
		//TODO fix test, this should return valid user
		when(userService.createUser(USER, PASS)).thenReturn(null);
		
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
