package com.slpl.web.entity.test;

public class AnswerScore {
    private int id;
    private int answerId;
    private int typeId;
    private int score;
    
	public AnswerScore() {
		// TODO Auto-generated constructor stub
	}
	public AnswerScore(int id, int answerId, int typeId, int score) {
		super();
		this.id = id;
		this.answerId = answerId;
		this.typeId = typeId;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnswer_id() {
		return answerId;
	}
	public void setAnswer_id(int answerId) {
		this.answerId = answerId;
	}
	public int getType_id() {
		return typeId;
	}
	public void setType_id(int typeId) {
		this.typeId = typeId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "AnswerScore [id=" + id + ", answerId=" + answerId + ", typeId=" + typeId + ", score=" + score + "]";
	}
    
    
}