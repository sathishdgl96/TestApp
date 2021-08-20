package com.smetutorials.demo.Models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
@CompoundIndexes({
    @CompoundIndex(name = "username", def = "{ 'username': 1 }", unique = true)
})
public class Photo {
    @Id
    private String id;
    private String username;
    private Binary image;

	@Override
	public String toString() {
		return "Photo [id=" + id + ", title=" + username + ", image=" + image + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setTitle(String username) {
		this.username = username;
	}

	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
	}

	public Photo(String username) {
		super();
		this.username = username;
	}
    
    
}