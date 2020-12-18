package com.slpl.web.entity.test;

import java.sql.Timestamp;

public class MemberTestAvgView {
	
	private int memberId;
	private String memberLoginId;
	private int regCnt;
	private int shereAvg;
	private int hitAvg;
	private int recommendAvg;
	private int bestCnt;
	

	public MemberTestAvgView() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberTestAvgView(int memberId, String memberLoginId, int regCnt, int shereAvg, int hitAvg, int recommendAvg,
			int bestCnt) {
		super();
		this.memberId = memberId;
		this.memberLoginId = memberLoginId;
		this.regCnt = regCnt;
		this.shereAvg = shereAvg;
		this.hitAvg = hitAvg;
		this.recommendAvg = recommendAvg;
		this.bestCnt = bestCnt;
	}

	

	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getMemberLoginId() {
		return memberLoginId;
	}


	public void setMemberLoginId(String memberLoginId) {
		this.memberLoginId = memberLoginId;
	}


	public int getRegCnt() {
		return regCnt;
	}


	public void setRegCnt(int regCnt) {
		this.regCnt = regCnt;
	}


	public int getShereAvg() {
		return shereAvg;
	}


	public void setShereAvg(int shereAvg) {
		this.shereAvg = shereAvg;
	}


	public int getHitAvg() {
		return hitAvg;
	}


	public void setHitAvg(int hitAvg) {
		this.hitAvg = hitAvg;
	}


	public int getRecommendAvg() {
		return recommendAvg;
	}


	public void setRecommendAvg(int recommendAvg) {
		this.recommendAvg = recommendAvg;
	}


	public int getBestCnt() {
		return bestCnt;
	}


	public void setBestCnt(int bestCnt) {
		this.bestCnt = bestCnt;
	}


	@Override
	public String toString() {
		return "MemberTestAvgView [memberId=" + memberId + ", memberLoginId=" + memberLoginId + ", regCnt=" + regCnt
				+ ", shereAvg=" + shereAvg + ", hitAvg=" + hitAvg + ", recommendAvg=" + recommendAvg + ", bestCnt="
				+ bestCnt + "]";
	}



	

}