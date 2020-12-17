package com.slpl.web.dao.member;

import java.util.List;

import com.slpl.web.entity.member.Message;

public interface MessageDao {
	int insert(Message message);   // 메세지 전송
	Message get(int id);
	List<Message> getList();
	
	Message getLast();
}
