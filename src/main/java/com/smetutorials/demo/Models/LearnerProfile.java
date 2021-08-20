package com.smetutorials.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("profile")
public class LearnerProfile 
{
private int id;
private String name;
private String phone;
private String institution;

public LearnerProfile(int id, String name, String phone, String institution) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.institution = institution;
}


public LearnerProfile() {
	super();
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getInstitution() {
	return institution;
}

public void setInstitution(String institution) {
	this.institution = institution;
}

@Override
public String toString() {
	return "LearnerProfile [id=" + id + ", name=" + name + ", phone=" + phone + ", institution=" + institution + "]";
}


}
