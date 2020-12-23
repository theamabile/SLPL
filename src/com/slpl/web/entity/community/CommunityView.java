package com.slpl.web.entity.community;

import java.util.Date;

public class CommunityView extends Community{

	private int commentCnt;
	private String memberName;
	private String noticeContent;
	private String  noticeTitle;
	private String commentContent;
	private Date commentRegdate;
	private Date noticeRegdate;
	private String memberNick;
	private String category;
	private int num;
	
	
	
	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

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
	
	
	
	

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentRegdate() {
		return commentRegdate;
	}

	public void setCommentRegdate(Date commentRegdate) {
		this.commentRegdate = commentRegdate;
	}

	public Date getNoticeRegdate() {
		return noticeRegdate;
	}

	public void setNoticeRegdate(Date noticeRegdate) {
		this.noticeRegdate = noticeRegdate;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public CommunityView(int id, int memberId, int categoryId, String title, String content, int recommendCnt,
			int hitCnt, String imgs, Date regDate, int commentCnt, String memberName, String noticeContent,
			String noticeTitle, String commentContent, Date commentRegdate, Date noticeRegdate, String memberNick,
			String category, int num) {
		super(id, memberId, categoryId, title, content, recommendCnt, hitCnt, imgs, regDate);
		this.commentCnt = commentCnt;
		this.memberName = memberName;
		this.noticeContent = noticeContent;
		this.noticeTitle = noticeTitle;
		this.commentContent = commentContent;
		this.commentRegdate = commentRegdate;
		this.noticeRegdate = noticeRegdate;
		this.memberNick = memberNick;
		this.category = category;
		this.num = num;
	}

	public CommunityView(int id, String title, int recommendCnt, int hitCnt, Date regDate, int commentCnt,
			String memberName, int categoryId, String memberNick, String category , int num) {
		super(id, categoryId, title, recommendCnt, hitCnt, regDate);
		this.commentCnt = commentCnt;
		this.memberName = memberName;
		this.memberNick = memberNick;
		this.category = category;
		this.num = num;
	}

	public CommunityView(int id, int memberId, int categoryId, String title, String content, int recommendCnt,
			int hitCnt, String imgs, Date regDate, String memberNick, int commentCnt) {
		super(id, categoryId, title, recommendCnt, hitCnt, regDate,content);
		this.commentCnt = commentCnt;
		this.memberName = memberName;
		this.memberNick = memberNick;
		this.category = category;
		this.num = num;
	}

	@Override
	public String toString() {
		return "CommunityView [commentCnt=" + commentCnt + ", memberName=" + memberName + ", noticeContent="
				+ noticeContent + ", noticeTitle=" + noticeTitle + ", commentContent=" + commentContent
				+ ", commentRegdate=" + commentRegdate + ", noticeRegdate=" + noticeRegdate + ", memberNick="
				+ memberNick + ", category=" + category + "]";
	}



	
	
	
	

//	public CommunityView(int id, int memberId, int categoryId, String title, String content, int recommendCnt,
//			int hitCnt, String imgs, Date regDate, int commentCnt, String memberName) {
//		super(id, memberId, categoryId, title, content, recommendCnt, hitCnt, imgs, regDate);
//		this.commentCnt = commentCnt;
//		this.memberName = memberName;
//	}
//
////	public CommunityView(int id, String title, int recommendCnt, int hitCnt, Date regDate, int commentCnt,
////			String memberName) {
////		
////		super(id, title, recommendCnt, hitCnt, regDate);
////		this.commentCnt = commentCnt;
////		this.memberName = memberName;
////	}
//
//	public CommunityView(int id, String title, int recommendCnt, int hitCnt, Date regDate, int commentCnt,
//			String memberName, int categoryId) {
//		super(id, title, recommendCnt, hitCnt, regDate,categoryId);
//		this.commentCnt = commentCnt;
//		this.memberName = memberName;
//		
//	}

	



}
