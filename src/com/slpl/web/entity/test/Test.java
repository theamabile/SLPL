package com.slpl.web.entity.test;

import java.sql.Timestamp;

public class Test {
	
	private int id;
	private String name;
	private String memberId;
	private String coverImg;
	private int publicState;
	private int bestState;
	private int shareCnt;
	private int hitCnt;
	private int recommendCnt;
	private int reportCnt;
	private Timestamp regDate;
	private int formCategory;
	

	public Test() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Test(int id, String name, String memberId, String coverImg, int publicState, int bestState, int shareCnt,
			int hitCnt, int recommendCnt, int reportCnt, Timestamp regDate, int formCategory) {
		super();
		this.id = id;
		this.name = name;
		this.memberId = memberId;
		this.coverImg = coverImg;
		this.publicState = publicState;
		this.bestState = bestState;
		this.shareCnt = shareCnt;
		this.hitCnt = hitCnt;
		this.recommendCnt = recommendCnt;
		this.reportCnt = reportCnt;
		this.regDate = regDate;
		this.formCategory = formCategory;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getCoverImg() {
		return coverImg;
	}


	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}


	public int getPublicState() {
		return publicState;
	}


	public void setPublicState(int publicState) {
		this.publicState = publicState;
	}


	public int getBestState() {
		return bestState;
	}


	public void setBestState(int bestState) {
		this.bestState = bestState;
	}


	public int getShareCnt() {
		return shareCnt;
	}


	public void setShareCnt(int shareCnt) {
		this.shareCnt = shareCnt;
	}


	public int getHitCnt() {
		return hitCnt;
	}


	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}


	public int getRecommendCnt() {
		return recommendCnt;
	}


	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}


	public int getReportCnt() {
		return reportCnt;
	}


	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}


	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	public int getFormCategory() {
		return formCategory;
	}


	public void setFormCategory(int formCategory) {
		this.formCategory = formCategory;
	}


	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", memberId=" + memberId + ", coverImg=" + coverImg
				+ ", publicState=" + publicState + ", bestState=" + bestState + ", shareCnt=" + shareCnt + ", hitCnt="
				+ hitCnt + ", recommendCnt=" + recommendCnt + ", reportCnt=" + reportCnt + ", regDate=" + regDate
				+ ", formCategory=" + formCategory + "]";
	}


}