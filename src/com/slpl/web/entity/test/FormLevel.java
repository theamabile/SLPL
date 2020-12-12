package com.slpl.web.entity.test;

public class FormLevel {
	private int id;
	private String name;
	private int questionCnt;
	private int typeCnt;
	private int answerCnt;
	private int formCategoryId;
	
	public FormLevel() {
		// TODO Auto-generated constructor stub
	}

	public FormLevel(int id, String name, int questionCnt, int typeCnt, int answerCnt, int formCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.questionCnt = questionCnt;
		this.typeCnt = typeCnt;
		this.answerCnt = answerCnt;
		this.formCategoryId = formCategoryId;
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

	public int getQuestionCnt() {
		return questionCnt;
	}

	public void setQuestionCnt(int questionCnt) {
		this.questionCnt = questionCnt;
	}

	public int getTypeCnt() {
		return typeCnt;
	}

	public void setTypeCnt(int typeCnt) {
		this.typeCnt = typeCnt;
	}

	public int getAnswerCnt() {
		return answerCnt;
	}

	public void setAnswerCnt(int answerCnt) {
		this.answerCnt = answerCnt;
	}

	public int getFormCategoryId() {
		return formCategoryId;
	}

	public void setFormCategoryId(int formCategoryId) {
		this.formCategoryId = formCategoryId;
	}

	@Override
	public String toString() {
		return "FormLevel [id=" + id + ", name=" + name + ", questionCnt=" + questionCnt + ", typeCnt=" + typeCnt
				+ ", answerCnt=" + answerCnt + ", formCategoryId=" + formCategoryId + "]";
	}
	
	
}
