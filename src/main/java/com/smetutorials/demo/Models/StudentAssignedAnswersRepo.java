package com.smetutorials.demo.Models;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;


public interface StudentAssignedAnswersRepo  extends MongoRepository<StudentAssignedAnswers,Integer>
{

public StudentAssignedAnswers findByTestidAndSuserid(String testid, String suserid);
public List<StudentAssignedAnswers> findBySuserid(String suserid);
}
