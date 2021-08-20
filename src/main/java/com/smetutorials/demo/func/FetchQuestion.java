package com.smetutorials.demo.func;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smetutorials.demo.Models.LearnerProfile;
import com.smetutorials.demo.Models.ProfileRepo;
import com.smetutorials.demo.Models.QuestionsMeta;
import com.smetutorials.demo.Models.QuestionsMetaRepo;
import com.smetutorials.demo.Models.SingleQuestion;
import com.smetutorials.demo.Models.SingleQuestionRepo;
import com.smetutorials.demo.Models.User;
import com.smetutorials.demo.Models.UserRepo;
import com.smetutorials.demo.controllers.Profile;

@Service
public class FetchQuestion 
{
	@Autowired
	SingleQuestionRepo qnRepo;
	@Autowired
	QuestionsMetaRepo qmetaRepo;
	@Autowired
	ProfileRepo profileRepo;
	@Autowired
	ObjectMapper mapper;
	String subject;
	String questionTitle;
	ObjectNode obj;
	
	public long checkInterval(int testid ) 
	{
		try
		{
		Optional<QuestionsMeta> qn=qmetaRepo.findById(testid);
		LocalDateTime date2=qn.get().getStartAt();
		LocalDateTime date1=LocalDateTime.now();
	    Duration duration = Duration.between(date2, date1);
	   System.out.println(duration.getSeconds());
	    return duration.getSeconds();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 10000000;
		}
	}
	
	public long checkEndInterval(int testid ) 
	{
		try
		{
		Optional<QuestionsMeta> qn=qmetaRepo.findById(testid);
		LocalDateTime date2=qn.get().getEndAt();
		LocalDateTime date1=LocalDateTime.now();
	    Duration duration = Duration.between(date1, date2);
	   System.out.println(duration.getSeconds());
	    return duration.getSeconds();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 10000000;
		}
	}
	
	public Optional<QuestionsMeta> getDate(int testid)
	{
		Optional<QuestionsMeta> qn=qmetaRepo.findById(testid);
		return qn;
	}

	public ArrayList<SingleQuestion> fetchQuestion(int testid)
	{
		ArrayList<SingleQuestion> questions=qnRepo.findByTestId(testid);
		return questions;
	}
	public HashMap<String, String> getDetails(int testid)
	{
		HashMap<String, String> details=new HashMap<>();
		try
		{
		Optional<QuestionsMeta> qn=qmetaRepo.findById(testid);
		Optional<LearnerProfile> user=null;
		if(qn.isPresent())
		{
			int teacherId=qn.get().getTeacherId();
			details.put("subject",qn.get().getSubject());
			details.put("questionTitle",qn.get().getqTitle());
			user=profileRepo.findById(teacherId);
		}
		details.put("creator",user.get().getName());
	}
		catch(Exception e)
		{
			e.printStackTrace();
			obj.put("creator","Something went wrong");
		}
		return details;
	}
	
}
