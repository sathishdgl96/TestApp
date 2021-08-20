package com.smetutorials.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.smetutorials.demo.Models.ApiKeyRepo;

@WebFilter("/logout")
public class LogoutFilter implements Filter 
{
	@Autowired
  ApiKeyRepo repo;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req=(HttpServletRequest)request;
		String apikey=(String) req.getParameter("apikey");
		repo.deleteByApikey(apikey);
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		session.invalidate();
		System.out.println("Session invalidated and api key deleted"+apikey);
		res.sendRedirect("/login");
}
}
