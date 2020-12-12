package com.slpl.web.entity.test;

public class Type {
    private int id;
    private String name;
    private int testId;
    
	public Type() {
		// TODO Auto-generated constructor stub
	}

	public Type(int id, String name, int testId) {
		this.id = id;
		this.name = name;
		this.testId = testId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", testId=" + testId + "]";
	}

}