package com.smetutorials.demo.rest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smetutorials.demo.Models.ApiKey;
import com.smetutorials.demo.Models.ApiKeyRepo;
import com.smetutorials.demo.Models.User;
import com.smetutorials.demo.Models.UserRepo;
import com.smetutorials.demo.func.GenerateApiKey;

@RestController
public class AuthResource 
{
	@Autowired
	UserRepo repo;
	@Autowired
	ApiKeyRepo repo1;
	@Autowired
	ObjectMapper mapper;
	User user;
	@Value("${ROLES.DEFAULT_ROLE}")
	private int default_role;
	@Value("${ACTIVE.DEFAULT_STATUS}")
	private int default_status;
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	
	@PostMapping(value="/loginrequest")
	@ResponseBody
	public ObjectNode requestLogin( HttpServletRequest request,@RequestParam(value="username", required=false) String username,
		    @RequestParam(value="password",required=false) String password, @RequestParam(value="apikey",required=false) String apikey) throws NoSuchAlgorithmException
	{
		System.out.println(username);
		System.out.println(password);
		ObjectNode objectNode = mapper.createObjectNode();
		/** Mock Object
		 * user=new User("sathish1",encoder.encode("123"),1,1);
		repo.save(user);
		*/
		
		if(apikey!=null)
		{
			ApiKey key=repo1.findByApikey(apikey);
			if(key!=null)
			{
			User user=repo.findByUsername(key.getEmail());
			HttpSession session=request.getSession();
			session.setAttribute("username",user.getUsername());
			session.setAttribute("userId",user.getId());
			session.setAttribute("isActive",user.getIsActive());
			session.setAttribute("role",user.getRole());
			objectNode.put("status",1);
			return objectNode;
			}
			else
			{
				objectNode.put("status",0);
				return objectNode;
				
			}
		}
		
		
		user=repo.findByUsername(username);
		if(user==null)
		{
			System.out.println("User not Exists");
			int id=new Random(System.nanoTime() % 100000).nextInt(1000000000);
			while(repo.existsById(id)) {id=new Random(System.nanoTime() % 100000).nextInt(1000000000);}
			user=new User(id,username,encoder.encode(password),default_role,default_status);
			GenerateApiKey key=new GenerateApiKey();
			ApiKey pair=key.generateKey(username);
			repo1.save(pair);
			repo.save(user);
			System.out.println("New user created, creating session... and api key.");
			try
			{
			HttpSession session=request.getSession();
			session.setAttribute("username",user.getUsername());
			session.setAttribute("userId",user.getId());
			session.setAttribute("isActive",user.getIsActive());
			session.setAttribute("role",user.getRole());
			}
			catch(Exception e)
			{
			System.out.println("Logged in from app :"+e);
			}
			 objectNode.put("apikey",pair.getApikey());
		    objectNode.put("status", 0);
		    objectNode.put("userid", user.getId());
		   
		    return objectNode;
		}
		else
		{
			System.out.println("User Exists");
			GenerateApiKey key=new GenerateApiKey();
			ApiKey pair=key.generateKey(username);
			repo1.save(pair);
			if(encoder.matches(password, user.getPassword()))
			{
				System.out.println("Password matched");
				/** Setting up session for http services*/
					try
					{
					HttpSession session=request.getSession();
					session.setAttribute("username",user.getUsername());
					session.setAttribute("userId",user.getId());
					session.setAttribute("isActive",user.getIsActive());
					session.setAttribute("role",user.getRole());
					session.setAttribute("apikey",pair.getApikey());
					}
					catch(Exception e)
					{
					System.out.println("Logged in from app :"+e);
					}
					 objectNode.put("apikey",pair.getApikey());
				    objectNode.put("status", 1);
				    objectNode.put("userid",user.getId());
				   
				    return objectNode;
			}
			else
			{
				System.out.println("Password failed");
				 objectNode.put("apikey",pair.getApikey());
			    objectNode.put("status", 2);
			    return objectNode;
				
			}
		}
	}
	

}
