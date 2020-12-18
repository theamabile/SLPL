package com.slpl.web.entity.community;
import java.util.Date;

public class CommunityRecommend {

	private int id;	
	private int memberId;    	
	private int communityId;	
	private Date regDate;
	public CommunityRecommend(int id, int memberId, int communityId, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityId = communityId;
		this.regDate = regDate;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CommunityRecommend [id=" + id + ", memberId=" + memberId + ", communityId=" + communityId + ", regDate="
				+ regDate + "]";
	}
	
	
	
	
}
