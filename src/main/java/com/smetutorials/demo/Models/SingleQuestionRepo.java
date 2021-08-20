package com.smetutorials.demo.Models;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SingleQuestionRepo  extends MongoRepository<SingleQuestion, Integer>
{
	public ArrayList<SingleQuestion> findByTestId(int testid);
	public ArrayList<SingleQuestion> findByTestIdAndQno(int testid, int qno);
}
