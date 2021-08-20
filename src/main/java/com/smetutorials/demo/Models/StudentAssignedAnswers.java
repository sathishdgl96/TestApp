package com.smetutorials.demo.Models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentAssignedAnswers 
{
	@Id
	int stExamId;
	String testid;
	String suserid;
	ArrayList<Integer> results = new ArrayList<>();
	public StudentAssignedAnswers(int stExamId, String testid, String suserid, ArrayList<Integer> results) {
		super();
		this.stExamId = stExamId;
		this.testid = testid;
		this.suserid = suserid;
		this.results = results;
	}
	
	public StudentAssignedAnswers() {
		super();
	}

	public StudentAssignedAnswers(int stExamId, String testid, String suserid) {
		super();
		this.stExamId = stExamId;
		this.testid = testid;
		this.suserid = suserid;
	}
	public int getStExamId() {
		return stExamId;
	}
	public void setStExamId(int stExamId) {
		this.stExamId = stExamId;
	}
	public String getTestid() {
		return testid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	public String getSuserid() {
		return suserid;
	}
	public void setSuserid(String suserid) {
		this.suserid = suserid;
	}
	public ArrayList<Integer> getResults() {
		return results;
	}
	public void setResults(ArrayList<Integer> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "StudentTestDetails [stExamId=" + stExamId + ", testid=" + testid + ", suserid=" + suserid + ", results="
				+ results + "]";
	}
	
}
