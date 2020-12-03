package com.slpl.web.board.all;

import java.util.Date;

public class Board {

		private int boardNo;				
		private String userId;		
		private String userNick;			
		private String title;		
		private String content;    	
		private int boardTypeId;  	
		private int hits;    	
		private int recommend;		   
		private Date regDate;
		
	public Board() {
		// TODO Auto-generated constructor stub
	}
		
	

		public Board(int boardNo, String userId, String userNick, String title, String content, int boardTypeId,
				int hits, int recommend, Date regDate) {
			super();
			this.boardNo = boardNo;
			this.userId = userId;
			this.userNick = userNick;
			this.title = title;
			this.content = content;
			this.boardTypeId = boardTypeId;
			this.hits = hits;
			this.recommend = recommend;
			this.regDate = regDate;
		}

		public Board(String title, String content) {

			this.title = title;
			this.content = content;
		}



		public int getBoardNo() {
			return boardNo;
		}

		public void setBoardNo(int boardNo) {
			this.boardNo = boardNo;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserNick() {
			return userNick;
		}

		public void setUserNick(String userNick) {
			this.userNick = userNick;
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

		public int getBoardTypeId() {
			return boardTypeId;
		}

		public void setBoardTypeId(int boardTypeId) {
			this.boardTypeId = boardTypeId;
		}

		public int getHits() {
			return hits;
		}

		public void setHits(int hits) {
			this.hits = hits;
		}

		public int getRecommend() {
			return recommend;
		}

		public void setRecommend(int recommend) {
			this.recommend = recommend;
		}

		public Date getRegDate() {
			return regDate;
		}

		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}

		@Override
		public String toString() {
			return "board [boardNo=" + boardNo + ", userId=" + userId + ", userNick=" + userNick + ", title=" + title
					+ ", content=" + content + ", boardTypeId=" + boardTypeId + ", hits=" + hits + ", recommend="
					+ recommend + ", regDate=" + regDate + "]";
		}


	

}
