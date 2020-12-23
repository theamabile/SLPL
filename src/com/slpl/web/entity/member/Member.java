package com.slpl.web.entity.member;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	
	private int id;
	private String loginId;
	private String pw; 
	private String name; 
	private String nickname; 
	private String gender; 
	private Date birthday; 
	private String phoneNumber; 
	private String email; 
	private Timestamp regdate;
	private String profileImg;
	private int categoryId;	
	
	// select용 - 전체
	public Member(int id, String loginId, String pw, String name, String nickname, String gender,
			Date birthday, String phoneNumber, String email, Timestamp regdate, String profileImg, int categoryId) {
		this.id = id;
		this.loginId = loginId;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.regdate = regdate;
		this.profileImg = profileImg;
		this.categoryId = categoryId;
	}
	
	// insert용 - id, regdate 없음
	public Member(String loginId, String pw, String name, String nickname, String gender,
			Date birthday, String phoneNumber, String email, String profileImg, int categoryId) {
		this.loginId = loginId;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.categoryId = categoryId;
		this.profileImg = profileImg;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
