package com.smetutorials.demo.rest;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smetutorials.demo.Models.ApiKey;
import com.smetutorials.demo.Models.QuestionsMeta;
import com.smetutorials.demo.Models.QuestionsMetaRepo;
import com.smetutorials.demo.Models.SingleQuestion;
import com.smetutorials.demo.Models.SingleQuestionRepo;
import com.smetutorials.demo.Models.StudentAssignedAnswers;
import com.smetutorials.demo.Models.StudentAssignedAnswersRepo;
import com.smetutorials.demo.Models.User;
import com.smetutorials.demo.Models.UserRepo;
import com.smetutorials.demo.func.GenerateApiKey;
import com.smetutorials.demo.func.ValidateApi;

@RestController
@Service
public class GenerateQuestionRest 
{
	@Autowired
	ObjectMapper mapper;
	@Autowired
	ValidateApi api;
	@Autowired
	StudentAssignedAnswersRepo assign;
	@Autowired
	QuestionsMetaRepo questionRepo;
	@Autowired
	UserRepo st;
	@Autowired
	SingleQuestionRepo sqnRepo;
	User student,student1;
	ApiKey temp_pass=null;
	String tempPassword="";



	@RequestMapping("lecture/question/addStudent")
	public ObjectNode addStudent(@RequestParam("apikey") String apikey,@RequestParam("sname") String sname,@RequestParam("testid") String testid) throws NoSuchAlgorithmException
	{
	SecureRandom rd=new SecureRandom();
	ObjectNode objectNode = mapper.createObjectNode();
	System.out.println("Add Student called");
	student=st.findByUsername("tmp_"+sname);
	student1=st.findByUsername(sname);
	System.out.println("user found"+student1);
	User user=api.checkApi(apikey);
	System.out.println("test id"+testid);
	if(user==null)
	{
		return null;
	}
	if(student==null && student1==null)
	{
		GenerateApiKey key=new GenerateApiKey();
		temp_pass=key.generateKey(sname);
		tempPassword=temp_pass.getApikey();
		objectNode.put("spassword",tempPassword);
		student=new User(rd.nextInt(999999),"tmp_"+sname,tempPassword,1,1);
		System.out.println("No such user exists and creating temporary user");
		st.save(student);
	}

	StudentAssignedAnswers test;
	StudentAssignedAnswers checkExists;
	if(student1!=null)
	{
	test=new StudentAssignedAnswers(rd.nextInt(9999999),testid,student1.getId()+"");
	checkExists=assign.findByTestidAndSuserid(testid,student1.getId()+"");
	objectNode.put("susername",student1.getUsername());
	}
	else
	{
 test=new StudentAssignedAnswers(rd.nextInt(9999999),testid,student.getId()+"");
  checkExists=assign.findByTestidAndSuserid(testid,student.getId()+"");
 objectNode.put("susername",student.getUsername());
	}

	if(checkExists==null)
	{
		objectNode.put("message","Added Successfully" );
	assign.save(test);
	}
	else
	{
		objectNode.put("message","User already added to the list" );
		return objectNode;
	}
	

	return objectNode ;
	}
	
	@RequestMapping("lecture/question/set-timing-and-title")
	public QuestionsMeta setTimeAndTitle(@RequestParam("apikey") String apikey,@RequestParam("testid") String testid,@RequestParam("questionTitle") String questionTitle,
			@RequestParam("startAt") String startAt,@RequestParam("subject") String subject, @RequestParam("endAt") String endAt, @RequestParam("isProctored") int isProctored, @RequestParam("isPublic") int isPublic)
	
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm"); 
		LocalDateTime startAtTime = LocalDateTime.parse(startAt, formatter);
		LocalDateTime endAtTime = LocalDateTime.parse(endAt, formatter);
		User teacher=api.checkApi(apikey);
		QuestionsMeta question=new QuestionsMeta(Integer.parseInt(testid),subject,questionTitle,teacher.getId(),startAtTime,endAtTime,isPublic,isProctored,1);
		questionRepo.save(question);
		return question;
		
	}
	
	@RequestMapping("/lecture/question/{testid}/{qno}")
	public SingleQuestion addQuestion(@RequestParam("apikey") String apikey, @RequestParam("question")
	String question, @RequestParam("options") ArrayList<String> options,@RequestParam("correctoption") String correctOption,
	@RequestParam("mark") String marks, @PathVariable("testid") String testid,@PathVariable("qno") int qno)
	{
		SecureRandom rd=new SecureRandom();
		SingleQuestion qn=new SingleQuestion(rd.nextInt(99999),Integer.parseInt(testid),qno,question,options,Integer.parseInt(correctOption),Integer.parseInt(marks));
		sqnRepo.save(qn);
		return qn;
	}

}

