package com.smetutorials.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smetutorials.demo.Models.ApiKey;
import com.smetutorials.demo.Models.QuestionsMeta;
import com.smetutorials.demo.Models.QuestionsMetaRepo;
import com.smetutorials.demo.Models.StudentAssignedAnswers;
import com.smetutorials.demo.Models.StudentAssignedAnswersRepo;
import com.smetutorials.demo.Models.User;
import com.smetutorials.demo.func.ValidateApi;

@RestController
@Service
public class GetExams 
{
	@Autowired
	ValidateApi api;
	@Autowired
	StudentAssignedAnswersRepo assignedStudentsRepo;
	@Autowired
	QuestionsMetaRepo questionmeta;
	
@GetMapping("/activeExams")	
public ArrayList<Optional<QuestionsMeta>> getActiveExams(@RequestParam("apikey") String apikey)
{
	User user=api.checkApi(apikey);
	List <StudentAssignedAnswers> tests=assignedStudentsRepo.findBySuserid(user.getId()+"");
	System.out.println("Active Exams called");
	ArrayList<Optional<QuestionsMeta>> testdetails=new ArrayList<>();
	for (StudentAssignedAnswers studentAssignedAnswers : tests)
	{
		String testid=studentAssignedAnswers.getTestid();
		testdetails.add(questionmeta.findById(Integer.parseInt(testid)));
		System.out.println("Students: "+studentAssignedAnswers);
	}
	
	return testdetails;
}
}
