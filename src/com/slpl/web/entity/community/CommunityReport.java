package com.slpl.web.entity.community;
import java.util.Date;

public class CommunityReport {

	private int id;	
	private int memberId;    	
	private int communityCategoryId;	
	private int communityId;	
	private Date regDate;
	
	
	
	
	public CommunityReport(int id, int memberId, int communityCategoryId, int communityId, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityCategoryId = communityCategoryId;
		this.communityId = communityId;
		this.regDate = regDate;
	}
	public CommunityReport(int id, int communityId, Date regDate) {
		super();
		this.id = id;
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
	public int getCommunityCategoryId() {
		return communityCategoryId;
	}
	public void setCommunityCategoryId(int communityCategoryId) {
		this.communityCategoryId = communityCategoryId;
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
		return "CommunityReport [id=" + id + ", memberId=" + memberId + ", communityCategoryId=" + communityCategoryId
				+ ", communityId=" + communityId + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
