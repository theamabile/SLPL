package com.slpl.web.entity.community;

import java.sql.Date;

public class CommentReport {
	private int id;
	private int memberId;
	private int communityId;
	private Date regdate;
	private String reason;
	
	
	public CommentReport(int id, int memberId, int communityId, Date regdate, String reason) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityId = communityId;
		this.regdate = regdate;
		this.reason = reason;
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
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "CommentReport [id=" + id + ", memberId=" + memberId + ", communityId=" + communityId + ", regdate="
				+ regdate + ", reason=" + reason + "]";
	}
	
	
}
