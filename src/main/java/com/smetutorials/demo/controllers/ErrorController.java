package com.smetutorials.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController 
{
	@RequestMapping("error1")
	public ModelAndView error404()
	{
		ModelAndView mv=new ModelAndView("/404");
		return mv;
	}

}
