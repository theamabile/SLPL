package com.slpl.web.entity.community;

import java.util.Date;

public class CommunityReportView extends CommunityReport{
	
	private String badMember;
	private int categoryId;
	private String reason;
	private String title;
	private String reportMember;
	public String getBadMember() {
		return badMember;
	}
	public void setBadMember(String badMember) {
		this.badMember = badMember;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReportMember() {
		return reportMember;
	}
	public void setReportMember(String reportMember) {
		this.reportMember = reportMember;
	}
	public CommunityReportView(int id, int memberId, int communityCategoryId, int communityId, Date regDate,
			String badMember, int communityId2, int categoryId, String reason, String title, String reportMember) {
		super(id, memberId, communityCategoryId, communityId, regDate);
		this.badMember = badMember;
		this.categoryId = categoryId;
		this.reason = reason;
		this.title = title;
		this.reportMember = reportMember;
	}
	public CommunityReportView(int id, String badMember, int communityId, int categoryId, String title,
			String reason, Date regDate, String reportMember) {
		super(id, communityId, regDate);
		this.badMember = badMember;
		this.categoryId = categoryId;
		this.reason = reason;
		this.title = title;
		this.reportMember = reportMember;
	}
	
	
	
	
	
	
	

	
	

}
