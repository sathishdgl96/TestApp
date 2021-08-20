package com.smetutorials.demo.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smetutorials.demo.Models.LearnerProfile;
import com.smetutorials.demo.Models.ProfileRepo;
import com.smetutorials.demo.Models.User;
import com.smetutorials.demo.func.ValidateApi;

@RestController
@Service
public class Profile 
{
	@Autowired
	ProfileRepo repo;
	@Autowired
	ValidateApi api;
	@PostMapping(value= "/profile/{Id}/update", produces = "application/json")
	@ResponseBody
	public LearnerProfile store(@RequestParam("apikey") String apikey,@RequestParam("name") String name,
			@RequestParam("phone") String phone,@RequestParam("institution") String institution,@PathVariable("Id") int id)
	{
		User user=api.checkApi(apikey);
		LearnerProfile profile=new LearnerProfile(user.getId(),name,phone,institution);
		
		try
		{
		if(!repo.existsById(id))
		{
			System.out.println("Id is"+id);
			
			repo.save(profile);
		}
		else
		{
			repo.deleteById(id);
			repo.save(profile);
		}
		return profile;
		}
		catch(Exception e)
		{
			return new LearnerProfile();
		}
	}
	
	@GetMapping(value= "/profile/{Id}/view", produces = "application/json")
	public Optional<LearnerProfile> view(@PathVariable("Id") int id, @RequestParam("apikey") String apikey)
	{
		User user=api.checkApi(apikey);
		Optional<LearnerProfile> ln=repo.findById(user.getId());
		return ln;
	}
}
