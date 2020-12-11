package com.slpl.web.entity;

public class Character {
	private int id;
	private String img;
	private String name;
	private String content;
	private int testId;
	
	public Character() {
		// TODO Auto-generated constructor stub
	}
	
	public Character(int id, String img, String name, String content, int testId) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.content = content;
		this.testId = testId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", img=" + img + ", name=" + name + ", content=" + content + ", testId=" + testId
				+ "]";
	}
	
	
	
}
