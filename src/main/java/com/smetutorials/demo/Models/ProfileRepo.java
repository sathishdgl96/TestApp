package com.smetutorials.demo.Models;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepo extends MongoRepository<LearnerProfile, Integer>
{
}
