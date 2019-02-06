package com.cruat.oauth.feature.users;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	// private static final Logger logger = LogManager.getLogger();
	public static final String USER = "user@cruat.com";
	public static final String PASS = "pswrd";
	public static final String UUID = "739eae4f-33da-4760-8931-6a8a809c7e24";

	@Mock
	UserService userService;

	@InjectMocks
	UserController controller;

}
