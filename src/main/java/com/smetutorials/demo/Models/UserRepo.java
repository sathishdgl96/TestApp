package com.smetutorials.demo.Models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, Integer>
{
	
	public User findByUsername(String username);
	public User findByRole(int role);
	public User findByUsernameAndPassword(String username,String password);

}
