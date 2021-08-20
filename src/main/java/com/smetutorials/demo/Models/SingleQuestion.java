package com.smetutorials.demo.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SingleQuestion 
{
	@Id
	int id;
	int testId;
	int qno;
	String question;
	List<String> options;
	int correctOption;
	int mark;
	public SingleQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SingleQuestion(int id, int testId, int qno, String question, List<String> options, int correctOption,
			int mark) {
		super();
		this.id = id;
		this.testId = testId;
		this.qno = qno;
		this.question = question;
		this.options = options;
		this.correctOption = correctOption;
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public int getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "SingleQuestion [id=" + id + ", testId=" + testId + ", qno=" + qno + ", question="
				+ question + ", options=" + options + ", correctOption=" + correctOption + ", mark=" + mark + "]";
	}
	
}