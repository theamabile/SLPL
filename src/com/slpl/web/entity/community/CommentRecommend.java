package com.slpl.web.entity.community;
import java.sql.Date;

public class CommentRecommend {
	private int id;
	private int memberId;
	private int communityId;
	private Date regdate;
	
	
	
	
	public CommentRecommend(int id, int memberId, int communityId, Date regdate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityId = communityId;
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
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "CommentRecommend [id=" + id + ", memberId=" + memberId + ", communityId=" + communityId + ", regdate="
				+ regdate + "]";
	}
	
}
