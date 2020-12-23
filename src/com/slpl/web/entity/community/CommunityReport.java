package com.slpl.web.entity.community;
import java.util.Date;

public class CommunityReport {

	private int id;	
	private int memberId;    	
	private int reportCategoryId;	
	private int communityId;	
	private Date regDate;
	
	
	
	
	public CommunityReport(int id, int memberId, int reportCategoryId, int communityId, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.reportCategoryId = reportCategoryId;
		this.communityId = communityId;
		this.regDate = regDate;
	}
	public CommunityReport(int id, int communityId, Date regDate) {
		super();
		this.id = id;
		this.communityId = communityId;
		this.regDate = regDate;
	}
	public CommunityReport(int id, int reason) {
		this.reportCategoryId = reason;
		this.communityId = id;
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
	public int getreportCategoryId() {
		return reportCategoryId;
	}
	public void setreportCategoryId(int reportCategoryId) {
		this.reportCategoryId = reportCategoryId;
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
		return "CommunityReport [id=" + id + ", memberId=" + memberId + ", reportCategoryId=" + reportCategoryId
				+ ", communityId=" + communityId + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
