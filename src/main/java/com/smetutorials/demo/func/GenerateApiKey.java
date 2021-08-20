package com.smetutorials.demo.func;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.KeyGenerator;
import com.smetutorials.demo.Models.ApiKey;

public class GenerateApiKey
{
	
public ApiKey generateKey(String username) throws NoSuchAlgorithmException
{
	final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	int len=32;
	SecureRandom rnd = new SecureRandom();
	   StringBuilder sb = new StringBuilder(len);
	   for(int i = 0; i < len; i++)
	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
	 ApiKey pair=new ApiKey(username,sb.toString());
	 return pair;
	
}
}
