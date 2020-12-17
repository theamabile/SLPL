package com.slpl.web.entity.member;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberView extends Member{

	private String categoryName;	// 카테고리 테이블에서 추가 포함된 항목
	private String authority;	    // 어드민 테이블에서 추가 포함된 항목
	
	public MemberView(int id, String loginId, String pw, String name, String nickname, String gender, Date birthday,
			String phoneNumber, String email, Timestamp regdate, String profileImg, int categoryId, 
			String categoryName, String authority) {
		super(id, loginId, pw, name, nickname, gender, birthday,
			phoneNumber, email, regdate, profileImg, categoryId);
		this.categoryName = categoryName;
		this.authority = authority;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
}
