package com.slpl.web.entity.test;

public class TestPlayView {
	private int tId;
	private String tName;
	private String tCoverImg;
	private int formType;
	private int qId;
	private int qNum;
	private String qContent;
	private String qImg;
	private int aId;
	private int aNum;
	private String aContent;
	private int sId;
	private int sScore;
	private int sTypeId;
	private int tpId;
	private String tpName;
	
	public TestPlayView(int tId, String tName, String tCoverImg, int formType, int qId, int qNum, String qContent,
			String qImg, int aId, int aNum, String aContent, int sId, int sScore, int sTypeId, int tpId,
			String tpName) {
		this.tId = tId;
		this.tName = tName;
		this.tCoverImg = tCoverImg;
		this.formType = formType;
		this.qId = qId;
		this.qNum = qNum;
		this.qContent = qContent;
		this.qImg = qImg;
		this.aId = aId;
		this.aNum = aNum;
		this.aContent = aContent;
		this.sId = sId;
		this.sScore = sScore;
		this.sTypeId = sTypeId;
		this.tpId = tpId;
		this.tpName = tpName;
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
	public String gettCoverImg() {
		return tCoverImg;
	}
	public void settCoverImg(String tCoverImg) {
		this.tCoverImg = tCoverImg;
	}
	public int getFormType() {
		return formType;
	}
	public void setFormType(int formType) {
		this.formType = formType;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqImg() {
		return qImg;
	}
	public void setqImg(String qImg) {
		this.qImg = qImg;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getaNum() {
		return aNum;
	}
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getsScore() {
		return sScore;
	}
	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
	public int getsTypeId() {
		return sTypeId;
	}
	public void setsTypeId(int sTypeId) {
		this.sTypeId = sTypeId;
	}
	public int getTpId() {
		return tpId;
	}
	public void setTpId(int tpId) {
		this.tpId = tpId;
	}
	public String getTpName() {
		return tpName;
	}
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	@Override
	public String toString() {
		return "TestPlayView [tId=" + tId + ", tName=" + tName + ", tCoverImg=" + tCoverImg + ", formType=" + formType
				+ ", qId=" + qId + ", qNum=" + qNum + ", qContent=" + qContent + ", qImg=" + qImg + ", aId=" + aId
				+ ", aNum=" + aNum + ", aContent=" + aContent + ", sId=" + sId + ", sScore=" + sScore + ", sTypeId="
				+ sTypeId + ", tpId=" + tpId + ", tpName=" + tpName + "]";
	}
}
