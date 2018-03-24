package com.crusnikatelier.oauth2.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.crusnikatelier.oauth2.data.entities.User;

@XmlRootElement(name="user")
public class UserDTO {
	
	String username;
	String guid;
	Date joined;
	
	public UserDTO() { 
		setUsername(null);
		setJoined(null);
		setGuid(null);
	}
	
	public UserDTO(User user){
		this();
		setUsername(user.getEmail());
		setJoined(user.getJoined());
	}
	
	@XmlElement(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElement(name="joined")
	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}
	
	@XmlElement(name="guid")
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
}
