package com.smetutorials.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document

public class ApiKey 
{

private String email;
private String apikey;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getApikey() {
	return apikey;
}
public ApiKey(String email, String apikey) {
	super();
	this.email = email;
	this.apikey = apikey;
	
}

public void setApikey(String apikey) {
	this.apikey = apikey;
}
@Override
public String toString() {
	return "ApiModel [email=" + email + ", apikey=" + apikey + "]";
}
}
