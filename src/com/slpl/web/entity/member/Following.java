package com.slpl.web.entity.member;

import java.sql.Date;

public class Following {
	private int id;
    private Date regdate;
    private int groupId;
    private int memberId;
    
    
	public Following(int id, Date regdate, int groupId, int memberId) {
		super();
		this.id = id;
		this.regdate = regdate;
		this.groupId = groupId;
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public int getGroupId() {
		return groupId;
	}
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "Following [id=" + id + ", regdate=" + regdate + ", groupId=" + groupId + ", memberId=" + memberId + "]";
	}    
    
}
