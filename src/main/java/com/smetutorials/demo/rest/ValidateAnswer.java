package com.smetutorials.demo.rest;

import java.util.ArrayList;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smetutorials.demo.Models.SingleQuestion;
import com.smetutorials.demo.Models.SingleQuestionRepo;
@Component
@RestController
public class ValidateAnswer 
{
	
	@Autowired
	ObjectMapper mapper;
	@Autowired
	SingleQuestionRepo qRepo;
	@PostMapping("/test/{testid}/{qno}")
	public int sendAns(@PathVariable("testid") int testid,@PathVariable("qno") int qno)
	{
		ObjectNode node=mapper.createObjectNode();
		ArrayList<SingleQuestion> result=qRepo.findByTestIdAndQno(testid, qno);
		System.out.println(result.get(0));
		return result.get(0).getCorrectOption();
	
	}

}
