package com.slpl.web.dao.member;

import com.slpl.web.entity.member.Message;

public interface MessageDao {
	int insert(Message message);   // 메세지 전송
}
