package com.slpl.web.entity;

import java.security.Timestamp;

public class TestReport {
	
	private int id;
	private String memberId;
	private String testId;
	private String season;
	private Timestamp regDate;
	
	
	
	public TestReport() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TestReport(int id, String memberId, String testId, String season, Timestamp regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.testId = testId;
		this.season = season;
		this.regDate = regDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	

	@Override
	public String toString() {
		return "TestReport [id=" + id + ", memberId=" + memberId + ", testId=" + testId + ", season=" + season
				+ ", regDate=" + regDate + "]";
	}
	
	

	
}
