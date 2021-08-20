package com.smetutorials.demo.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController 
{
	
	@RequestMapping("/getTime")
public String getCurrentTime()
{
	String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	return timeStamp;
	
}
	
}
