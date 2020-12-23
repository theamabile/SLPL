package com.slpl.web.entity.community;
import java.util.Date;

public class Community {

		private int id;				
		private int memberId;		
		private int categoryId;			
		private String title;		
		private String content;    	
		private int recommendCnt;  	
		private int hitCnt;    	
		private String imgs;		   
		private Date regDate;
		private String category;
		
		
		
		
		
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Community(int id, int memberId, int categoryId, String title, String content, int recommendCnt,
				int hitCnt, String imgs, Date regDate) {
			super();
			this.id = id;
			this.memberId = memberId;
			this.categoryId = categoryId;
			this.title = title;
			this.content = content;
			this.recommendCnt = recommendCnt;
			this.hitCnt = hitCnt;
			this.imgs = imgs;
			this.regDate = regDate;
			this.category = category;
		}
		public Community(String title, String content) {
			this.title = title;
			this.content = content;
		}
//		public Community(int id, String title, int recommendCnt, int hitCnt, Date regDate) {
//			this.id = id;
//			this.title = title;
//			this.recommendCnt = recommendCnt;
//			this.hitCnt = hitCnt;
//			this.regDate = regDate;
//		}
		public Community(int id, String title, int recommendCnt, int hitCnt, Date regDate, int categoryId) {
			this.id = id;
			this.title = title;
			this.recommendCnt = recommendCnt;
			this.hitCnt = hitCnt;
			this.regDate = regDate;
			this.categoryId = categoryId;
		}
		public Community(int id, int categoryId, String title, int recommendCnt, int hitCnt, Date regDate) {
			this.id = id;
			this.title = title;
			this.recommendCnt = recommendCnt;
			this.hitCnt = hitCnt;
			this.regDate = regDate;
			this.categoryId = categoryId;
		}
		public Community(int id, int memberId, int categoryId, String title, String content, int recommendCnt,
				int hitCnt, String imgs, Date regDate, String memberNick, int commentCnt) {
			this.id = id;
			this.title = title;
			this.recommendCnt = recommendCnt;
			this.hitCnt = hitCnt;
			this.regDate = regDate;
			this.categoryId = categoryId;
		}
		public Community(int id, int categoryId, String title, int recommendCnt, int hitCnt, Date regDate,
				String content) {
			this.id = id;
			this.title = title;
			this.recommendCnt = recommendCnt;
			this.hitCnt = hitCnt;
			this.regDate = regDate;
			this.categoryId = categoryId;
			this.content = content;
		}
		public Community(String title, String content, String category) {
			this.title = title;
			this.content = content;
			this.category = category;
			this.categoryId = categoryId;
		}
		public Community(String title, String content, String category, int categoryId) {
			this.title = title;
			this.content = content;
			this.category = category;
			this.categoryId = categoryId;
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
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
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
		public int getRecommendCnt() {
			return recommendCnt;
		}
		public void setRecommendCnt(int recommendCnt) {
			this.recommendCnt = recommendCnt;
		}
		public int getHitCnt() {
			return hitCnt;
		}
		public void setHitCnt(int hitCnt) {
			this.hitCnt = hitCnt;
		}
		public String getImgs() {
			return imgs;
		}
		public void setImgs(String imgs) {
			this.imgs = imgs;
		}
		public Date getRegDate() {
			return regDate;
		}
		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}
		@Override
		public String toString() {
			return "Community [id=" + id + ", memberId=" + memberId + ", categoryId=" + categoryId + ", title=" + title
					+ ", content=" + content + ", recommendCnt=" + recommendCnt + ", hitCnt=" + hitCnt + ", imgs="
					+ imgs + ", regDate=" + regDate + "]";
		}
		
	


	

}
