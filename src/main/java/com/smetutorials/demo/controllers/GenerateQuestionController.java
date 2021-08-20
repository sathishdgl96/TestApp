package com.smetutorials.demo.controllers;

import java.security.SecureRandom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenerateQuestionController 
{

	@GetMapping("/lecture/generate")
public ModelAndView quizGenerator()
{
		System.out.println("called");
	ModelAndView model=new ModelAndView("/lecture/generate");
	SecureRandom rd=new SecureRandom();
	model.addObject("testid",rd.nextInt(999999999));
	return model;
}
	@GetMapping("/lecture/generate/questions")
public ModelAndView addQuestions()
{
	ModelAndView mv=new ModelAndView("/lecture/questions");
	return mv;
	
}
	
}
