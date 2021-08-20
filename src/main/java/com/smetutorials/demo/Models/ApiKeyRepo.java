package com.smetutorials.demo.Models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ApiKeyRepo extends MongoRepository<ApiKey,Integer> 
{

	public ApiKey findByApikey(String apikey);
	public ApiKey deleteByApikey(String apikey);
}
