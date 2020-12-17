package com.slpl.web.entity.test;

public class Answer {
    private int id;
    private int no;
    private String content;
    private int questionId;
	
    public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(int id, int no, String content, int questionId) {
		super();
		this.id = id;
		this.no = no;
		this.content = content;
		this.questionId = questionId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getQuestion_id() {
		return questionId;
	}

	public void setQuestion_id(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", no=" + no + ", content=" + content + ", questionId=" + questionId + "]";
	}

}