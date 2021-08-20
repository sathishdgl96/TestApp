package com.smetutorials.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smetutorials.demo.Models.SingleQuestion;
import com.smetutorials.demo.func.FetchQuestion;
import com.smetutorials.demo.rest.GetQuestionPaper;

@Controller
@Component
public class QuestionController 
{
	@Autowired
	FetchQuestion qn;
	@RequestMapping("/test/{testid}")
	public ModelAndView getQuestions(@PathVariable("testid") int testid)
	{
		ModelAndView mv=new ModelAndView("/question");
		long interval=qn.checkInterval(testid);
		if(interval<0)
		{
			mv.addObject("interval",interval);
			mv.addObject("startat",qn.getDate(testid).get().getStartAt());
			mv.addObject("title",qn.getDate(testid).get().getqTitle());
			mv.setViewName("/time-error");
		}
		long endInterval=qn.checkEndInterval(testid);
		if(endInterval<0)
		{
			mv.addObject("interval",interval);
			mv.addObject("endat",qn.getDate(testid).get().getEndAt());
			mv.addObject("title",qn.getDate(testid).get().getqTitle());
			mv.addObject("message","Timeout !, Assesment duration exceeded...");
			mv.setViewName("redirect:/dashboard");
		}
		ArrayList<SingleQuestion> questions=qn.fetchQuestion(testid);
		mv.addObject("questions",questions);
		HashMap<String, String> node=qn.getDetails(testid);
		mv.addObject("endat",qn.getDate(testid).get().getEndAt());
		mv.addObject("details",node);
		return mv;
	}

}
