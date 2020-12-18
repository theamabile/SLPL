package com.slpl.web.entity.test;

import java.security.Timestamp;

public class PlayList {
	
	private int id;
	private String memberId;
	private String testId;
	private Timestamp regDate;
	
	
	
	public PlayList() {
		// TODO Auto-generated constructor stub
	}


	public PlayList(int id, String memberId, String testId, Timestamp regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.testId = testId;
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



	public Timestamp getRegDate() {
		return regDate;
	}



	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	


	@Override
	public String toString() {
		return "PlayList [id=" + id + ", memberId=" + memberId + ", testId=" + testId + ", regDate=" + regDate + "]";
	}


	
}