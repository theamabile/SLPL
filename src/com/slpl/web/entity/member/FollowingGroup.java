package com.slpl.web.entity.member;

public class FollowingGroup {
	private int id;
    private String name;
    private int memberCnt;
    private int memberId;
    
	public FollowingGroup(int id, String name, int memberCnt, int memberId) {
		this.id = id;
		this.name = name;
		this.memberCnt = memberCnt;
		this.memberId = memberId;
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
	
	public int getMemberCnt() {
		return memberCnt;
	}
	
	public void setMemberCnt(int memberCnt) {
		this.memberCnt = memberCnt;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "FollowingGroup [id=" + id + ", name=" + name + ", memberCnt=" + memberCnt + ", memberId=" + memberId
				+ "]";
	}
    
    
    
}
