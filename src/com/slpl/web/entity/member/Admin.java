package com.slpl.web.entity.member;

public class Admin {
	private int memberId;
	
	public Admin(int memberId) {
		this.memberId = memberId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Admin [memberId=" + memberId + "]";
	}

}
