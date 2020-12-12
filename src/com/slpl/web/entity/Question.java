package com.slpl.web.entity.test;

public class Question{
    private int id;
    private int no;
    private int testId;
    private String img;
    private String content;
	
    public Question() {
		// TODO Auto-generated constructor stub
	}
	public Question(int id, int no, int testId, String img, String content) {
		super();
		this.id = id;
		this.no = no;
		this.testId = testId;
		this.img = img;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", no=" + no + ", testId=" + testId + ", img=" + img + ", content=" + content
				+ "]";
	}
    
    
}