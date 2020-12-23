package com.slpl.web.entity.test;

import java.sql.Date;

public class TestResult {
	private int id;
	private int testId;
	private Date regdate;
	
	public TestResult() {
		// TODO Auto-generated constructor stub
	}

	public TestResult(int id, int testId, Date regdate) {
		super();
		this.id = id;
		this.testId = testId;
		this.regdate = regdate;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", testId=" + testId + ", regdate=" + regdate + "]";
	}
}
