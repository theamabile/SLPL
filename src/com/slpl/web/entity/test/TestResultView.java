package com.slpl.web.entity.test;

import java.sql.Date;

public class TestResultView {
	private int tId;
    private String tName;
    private String tMemberName;
    private Date tRegdate;
    private int tHitCnt;
    private int tRecomCnt;
    private int cId;
    private String cName;
    private String cImg;
    private String cContent;
    
	public TestResultView(int tId, String tName, String tMemberName, Date tRegdate, int tHitCnt, int tRecomCnt, int cId,
			String cName, String cImg, String cContent) {
		this.tId = tId;
		this.tName = tName;
		this.tMemberName = tMemberName;
		this.tRegdate = tRegdate;
		this.tHitCnt = tHitCnt;
		this.tRecomCnt = tRecomCnt;
		this.cId = cId;
		this.cName = cName;
		this.cImg = cImg;
		this.cContent = cContent;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettMemberName() {
		return tMemberName;
	}

	public void settMemberName(String tMemberName) {
		this.tMemberName = tMemberName;
	}

	public Date gettRegdate() {
		return tRegdate;
	}

	public void settRegdate(Date tRegdate) {
		this.tRegdate = tRegdate;
	}

	public int gettHitCnt() {
		return tHitCnt;
	}

	public void settHitCnt(int tHitCnt) {
		this.tHitCnt = tHitCnt;
	}

	public int gettRecomCnt() {
		return tRecomCnt;
	}

	public void settRecomCnt(int tRecomCnt) {
		this.tRecomCnt = tRecomCnt;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcImg() {
		return cImg;
	}

	public void setcImg(String cImg) {
		this.cImg = cImg;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	@Override
	public String toString() {
		return "TestResultView [tId=" + tId + ", tName=" + tName + ", tMemberName=" + tMemberName + ", tRegdate="
				+ tRegdate + ", tHitCnt=" + tHitCnt + ", tRecomCnt=" + tRecomCnt + ", cId=" + cId + ", cName=" + cName
				+ ", cImg=" + cImg + ", cContent=" + cContent + "]";
	}
    
}
