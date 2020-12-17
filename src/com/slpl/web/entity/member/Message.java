package com.slpl.web.entity.member;

import java.sql.Timestamp;

public class Message {
	private int id;
    private String title;
    private String content;
    private String type;
    
	public Message(int id, String title, String content, String type) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
	}
	
	public Message(String title, String content, String type) {
		this.title = title;
		this.content = content;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", type=" + type + "]";
	}
	
	
	
}
