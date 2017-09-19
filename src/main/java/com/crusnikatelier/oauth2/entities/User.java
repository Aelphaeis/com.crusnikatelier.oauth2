package com.crusnikatelier.oauth2.entities;

import java.util.Date;

/**
 * 
 * @author joseph.morain
 *
 */
public class User {
	//number integer
	int id;
	
	//String 254 legnth
	String email;
	
	//
	String salt;
	
	//128 characters SHA3-512
	String hash;
	
	//Just a date in UTC
	Date joined;
	
	//36 Characters
	String guid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
}
