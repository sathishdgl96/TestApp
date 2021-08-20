package com.smetutorials.demo.Models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsMetaRepo extends MongoRepository<QuestionsMeta, Integer>
{

}
