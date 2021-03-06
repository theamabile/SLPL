package com.slpl.web.entity.test;

import java.sql.Timestamp;

public class Test {
	
	private int id;
	private String name;
	private int memberId;
	private String coverImg;
	private int publicState;
	private int bestState;
	private int shareCnt;
	private int hitCnt;
	private int recommendCnt;
	private int reportCnt;
	private Timestamp regdate;
	private int formLevelId;
	

	public Test() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Test(int id, String name, int memberId, String coverImg, int publicState, int bestState, int shareCnt,
			int hitCnt, int recommendCnt, int reportCnt, Timestamp regdate, int formLevelId) {
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
		this.regdate = regdate;
		this.formLevelId = formLevelId;
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


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
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


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}


	public int getFormLevelId() {
		return formLevelId;
	}


	public void setFormLevelId(int formLevelId) {
		this.formLevelId = formLevelId;
	}


	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", memberId=" + memberId + ", coverImg=" + coverImg
				+ ", publicState=" + publicState + ", bestState=" + bestState + ", shareCnt=" + shareCnt + ", hitCnt="
				+ hitCnt + ", recommendCnt=" + recommendCnt + ", reportCnt=" + reportCnt + ", regdate=" + regdate
				+ ", formLevelId=" + formLevelId + "]";
	}


}