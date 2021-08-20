package com.smetutorials.demo.controllers;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smetutorials.demo.Models.Photo;
import com.smetutorials.demo.service.PhotoService;

@RestController
public class BinaryDataController 
{
	
	@Autowired
	PhotoService photoService;
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("image") MultipartFile image, Model model,HttpServletRequest req) 
	  throws IOException 
	{
		HttpSession session=req.getSession();
		String title=(String) session.getAttribute("username");
	    String username = photoService.addPhoto(title, image);
	    return "redirect:/photos/" + username;
	}
	
	
	@GetMapping("/photos/{username}")
	public String getPhoto(@PathVariable String username, Model model) 
	{
	    Photo photo = photoService.getPhoto(username);
	    model.addAttribute("title", photo.getUsername());
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(photo.getImage().getData()));
	    return "photos";
	}
}
