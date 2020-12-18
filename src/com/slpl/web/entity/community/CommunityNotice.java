package com.slpl.web.entity.community;
import java.util.Date;

public class CommunityNotice {
	
	private int id;	
	private int memberId;    	
	private int communityCategoryId;	
	private String title;		
	private String content;	
	private Date regDate;
	
	
	
	
	
	public CommunityNotice(int id, int memberId, int communityCategoryId, String title, String content, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityCategoryId = communityCategoryId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public CommunityNotice(int id, String title, String content, Date regDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public CommunityNotice(int id, String title, String content, Date regDate, int communityCategoryId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.communityCategoryId = communityCategoryId;
	}

	public CommunityNotice(String title, String content) {
		super();
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


	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "CommunityNotice [id=" + id + ", memberId=" + memberId + ", communityCategoryId=" + communityCategoryId
				+ ", title=" + title + ", content=" + content + ", regDate=" + regDate + "]";
	}

	
	
}
