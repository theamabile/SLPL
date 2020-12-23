package com.slpl.web.entity.community;

import java.sql.Timestamp;
import java.util.Date;

public class CommentView extends CommentReg{
	
	private String nickName;
	
	

	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public CommentView(int id, int memberId, int communityId, String content, Timestamp regdate, String nickName) {
		super(id, memberId, communityId, content, regdate);
		this.nickName = nickName;
	}





	@Override
	public String toString() {
		return "CommentView [nickName=" + nickName + "]";
	}

	
	

}
