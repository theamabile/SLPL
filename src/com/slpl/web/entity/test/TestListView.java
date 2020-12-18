package com.slpl.web.entity.test;

import java.sql.Timestamp;

public class TestListView extends Test {

	private String nickname;
	private String levName;
	private String cateName;

	public TestListView() {
		// TODO Auto-generated constructor stub
	}

	public TestListView(int id, String name, int memberId, String coverImg, int publicState, int bestState,
			int shareCnt, int hitCnt, int recommendCnt, int reportCnt, Timestamp regDate, int formLevelId,
			String nickname, String levName, String cateName) {
		super(id, name, memberId, coverImg, publicState, bestState, shareCnt, hitCnt, recommendCnt, reportCnt, regDate,
				formLevelId);
		this.nickname = nickname;
		this.levName = levName;
		this.cateName = cateName;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLevName() {
		return levName;
	}

	public void setLevName(String levName) {
		this.levName = levName;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "TestListView [nickname=" + nickname + ", levName=" + levName + ", cateName=" + cateName + "]";
	}
	
}
	
	

	