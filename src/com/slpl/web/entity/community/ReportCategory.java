package com.slpl.web.entity.community;
public class ReportCategory {
	
	private int id;	
	private String content;
	
	
	
	public ReportCategory(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReportCategory [id=" + id + ", content=" + content + "]";
	}
	
	
	

}
