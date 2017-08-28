package com.crusnikatelier.oauth2.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.crusnikatelier.oauth2.entities.User;

@XmlRootElement(name="user")
public class UserDTO {
	
	String username;
	Date joined;
	
	public UserDTO() { }
	
	public UserDTO(User user){
		this();
		setUsername(user.getEmail());
		setJoined(user.getJoined());
	}
	
	@XmlElement(name="username", nillable=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElement(name="joined", nillable=true)
	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}
}
