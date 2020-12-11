package com.slpl.web.entity.member;

import java.sql.Date;

public class Message {
	private int id;
	private int adminId;
	private int memberId;
    private Date reddate;
    private String title;
    private String content;
    
	public Message(int id, int adminId, int memberId, Date reddate, String title, String content) {
		this.id = id;
		this.adminId = adminId;
		this.memberId = memberId;
		this.reddate = reddate;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getReddate() {
		return reddate;
	}
	
	public void setReddate(Date reddate) {
		this.reddate = reddate;
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
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", reddate=" + reddate + ", title=" + title + ", content=" + content + "]";
	}
    
}
