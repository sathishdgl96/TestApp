package com.smetutorials.demo.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smetutorials.demo.Models.Photo;
import com.smetutorials.demo.Models.PhotoRepository;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepo;

	public String addPhoto(String username, MultipartFile file) throws IOException {
		Photo photo = new Photo(username);
		photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		if(photoRepo.findByUsername(username)!=null)
		{
			photoRepo.deleteByUsername(username);
		}
		photo = photoRepo.save(photo);
		return photo.getUsername();
	}

	public Photo getPhoto(String username) {
		return photoRepo.findByUsername(username);
	}
}