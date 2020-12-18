package com.slpl.web.entity.community;

import java.util.Date;

public class CommunityNoticeView extends CommunityNotice{
	
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CommunityNoticeView(int id, int memberId, int communityCategoryId, String title, String content,
			Date regDate, String categoryName) {
		super(id, memberId, communityCategoryId, title, content, regDate);
		this.categoryName = categoryName;
	}

	public CommunityNoticeView(int id, String title, String content, Date regDate, String categoryName, int communityCategoryId) {
		super(id, title, content, regDate,communityCategoryId);
		
		this.categoryName = categoryName;
		
	}

	public CommunityNoticeView(int id, String title, String content, Date regDate, String categoryName) {
		super(id, title, content, regDate);
		this.categoryName = categoryName;
	}
	
	

}
