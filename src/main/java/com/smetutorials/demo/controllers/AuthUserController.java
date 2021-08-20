package com.smetutorials.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthUserController 
{
@RequestMapping("/login")
public ModelAndView login()
{
	ModelAndView mv=new ModelAndView("login");
	return mv;
}

}
