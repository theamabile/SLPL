package com.slpl.web.entity.community;

import java.sql.Date;

public class CommentReg {
	private int id;
	private int memberId;
	private int communityId;
	private String content;
	private Date regdate;
	
	
	
	
	public CommentReg(int id, int memberId, int communityId, String content, Date regdate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityId = communityId;
		this.content = content;
		this.regdate = regdate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getCommunityId() {
		return communityId;
	}
	
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "CommentReg [id=" + id + ", memberId=" + memberId + ", communityId=" + communityId + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
}
