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

import org.springframework.web.bind.annotation.CookieValue;
@WebFilter(urlPatterns={"/login","/signup"})
public class AuthUserFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		if(session.getAttribute("username") != null)
		{
			System.out.println("Filter paased and username is set");	
		res.sendRedirect("/dashboard");	
		}
		else
		{
			System.out.println("Filter paased");
		chain.doFilter(request, response);
		}
	}

}
