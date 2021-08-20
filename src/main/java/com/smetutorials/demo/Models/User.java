package com.smetutorials.demo.Models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User 
{
	@Id
private int id;
private String username;
private String password;
private int role;
private int isActive;

public User() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public int getIsActive() {
	return isActive;
}
public void setIsActive(int isActive) {
	this.isActive = isActive;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", role=" + role + ", isActive="
			+ isActive + "]";
}

public User(int id,String username, String password, int role, int isActive) {
	super();
	this.id=id;
	this.username = username;
	this.password = password;
	this.role = role;
	this.isActive = isActive;
}

}
