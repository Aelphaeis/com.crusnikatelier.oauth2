package com.crusnikatelier.oauth2.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Joseph Morain
 *
 */
@Entity
@Table(name="users")
public class User {
	
	@Id
	int id;
	
	@Column(name="email", length=254, nullable=false, unique=true)
	String email;
	
	@Column(name="salt", length=32, nullable=false, unique=false)
	String salt;
	
	@Column(name="hash", length=60, nullable=false, unique=false)
	String hash;
	
	@Column(name="joined", nullable=false)
	Date joined;
	
	@Column(name="guid", length=36, nullable=false, unique=true)
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
