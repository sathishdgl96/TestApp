package com.smetutorials.demo.func;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.smetutorials.demo.Models.ApiKey;
import com.smetutorials.demo.Models.ApiKeyRepo;
import com.smetutorials.demo.Models.User;
import com.smetutorials.demo.Models.UserRepo;

@Component
public class ValidateApi 
{
	@Autowired
	ApiKeyRepo keyrepo;
	@Autowired
	UserRepo userrepo;
	
public User checkApi(String apikey)
{
	
	User user=null;
	try
	{
	ApiKey key=keyrepo.findByApikey(apikey);
	user=userrepo.findByUsername(key.getEmail());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return user;
}
}
