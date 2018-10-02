package com.cruat.oauth.feature.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	UserService userService;
	
	@InjectMocks
	UserController controller;
	
	@Test
	public void test() throws Exception {
		RequestBuilder rb = MockMvcRequestBuilders.get("/me");
		MockMvcBuilder mvcb = MockMvcBuilders.standaloneSetup(controller);
		mvcb.build().perform(rb).andReturn();
	}

}
