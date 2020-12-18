package com.slpl.web.entity.community;

import java.util.Date;

public class CommunityView extends Community{

	private int commentCnt;
	private String memberName;

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public CommunityView(int id, int memberId, int categoryId, String title, String content, int recommendCnt,
			int hitCnt, String imgs, Date regDate, int commentCnt, String memberName) {
		super(id, memberId, categoryId, title, content, recommendCnt, hitCnt, imgs, regDate);
		this.commentCnt = commentCnt;
		this.memberName = memberName;
	}

//	public CommunityView(int id, String title, int recommendCnt, int hitCnt, Date regDate, int commentCnt,
//			String memberName) {
//		
//		super(id, title, recommendCnt, hitCnt, regDate);
//		this.commentCnt = commentCnt;
//		this.memberName = memberName;
//	}

	public CommunityView(int id, String title, int recommendCnt, int hitCnt, Date regDate, int commentCnt,
			String memberName, int categoryId) {
		super(id, title, recommendCnt, hitCnt, regDate,categoryId);
		this.commentCnt = commentCnt;
		this.memberName = memberName;
		
	}

	



}
