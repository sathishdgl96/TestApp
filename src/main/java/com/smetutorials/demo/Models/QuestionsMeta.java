package com.smetutorials.demo.Models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

public class QuestionsMeta 
{

	@Id
	int testid;
	String subject;
	String qTitle;
	int teacherId;
	LocalDateTime startAt, endAt;
	int isPublic,isProctored,isPublish;	
	public QuestionsMeta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public LocalDateTime getStartAt() {
		return startAt;
	}
	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}
	public LocalDateTime getEndAt() {
		return endAt;
	}
	public void setEndAt(LocalDateTime endAt) {
		this.endAt = endAt;
	}
	public int getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	public int getIsProctored() {
		return isProctored;
	}
	public void setIsProctored(int isProctored) {
		this.isProctored = isProctored;
	}
	public int getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(int isPublish) {
		this.isPublish = isPublish;
	}
	public QuestionsMeta(int testid, String subject, String qTitle, int teacherId, LocalDateTime startAt,
			LocalDateTime endAt, int isPublic, int isProctored, int isPublish) {
		super();
		this.testid = testid;
		this.subject = subject;
		this.qTitle = qTitle;
		this.teacherId = teacherId;
		this.startAt = startAt;
		this.endAt = endAt;
		this.isPublic = isPublic;
		this.isProctored = isProctored;
		this.isPublish = isPublish;
	}
	@Override
	public String toString() {
		return "QuestionsMeta [testid=" + testid + ", subject=" + subject + ", qTitle=" + qTitle + ", teacherId="
				+ teacherId + ", startAt=" + startAt + ", endAt=" + endAt + ", isPublic=" + isPublic + ", isProctored="
				+ isProctored + ", isPublish=" + isPublish + "]";
	}
	
}
