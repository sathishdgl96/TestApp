package com.smetutorials.demo.Models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
	
	public Photo findByUsername(String username);
	public Photo deleteByUsername(String username);
}