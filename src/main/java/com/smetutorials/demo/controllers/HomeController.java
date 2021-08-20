package com.smetutorials.demo.controllers;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smetutorials.demo.Models.Photo;
import com.smetutorials.demo.Models.PhotoRepository;
import com.smetutorials.demo.service.PhotoService;

@Controller
public class HomeController 
{
	@Autowired
	PhotoService photoService;
	@Autowired
	PhotoRepository repo;
	@RequestMapping("/")
public ModelAndView Home()
{
	ModelAndView mv=new ModelAndView("dashboard");
	return mv;
}
	@RequestMapping("/dashboard")
public ModelAndView dashboard()
{
	ModelAndView mv=new ModelAndView("dashboard");
	return mv;
}
	@RequestMapping("/onboarding")
public ModelAndView profile(HttpServletRequest request)
{
		
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
	ModelAndView mv=new ModelAndView("profile");
	if(repo.findByUsername(username)!=null)
	{
	    Photo photo = photoService.getPhoto(username);
	    mv.addObject("title", photo.getUsername());
	    mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
	}
	 	return mv;
}
@RequestMapping("/lecture")
public ModelAndView lecture()
{
	ModelAndView lecture=new ModelAndView("/lecture/dashboard");
	return lecture;
}

@RequestMapping("/photo")
public ModelAndView photo()
{
	ModelAndView lecture=new ModelAndView("/photo");
	return lecture;
}
}
