package com.crusnikatelier.oauth2.entities;

import java.sql.Date;

public class User {
	int id;
	String email;
	String salt;
	String password;
	Date joined;
}
