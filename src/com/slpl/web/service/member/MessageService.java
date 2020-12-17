package com.slpl.web.service.member;

import com.slpl.web.dao.jdbc.JdbcMessageDao;
import com.slpl.web.dao.member.MessageDao;
import com.slpl.web.entity.member.Message;

public class MessageService {

	// 여기서 생성자 안만들고 외부로 뺄거임. 내부에 넣으면 결함력 강해짐.
	// 기업용은 보통 외부에 뺌. 완성인지 미완성인지 어떤거 쓸지 모르니까.
	public MessageDao messageDao;

	public MessageService() {
		messageDao = new JdbcMessageDao();
	}
	
	public int insert(Message message) {
		// TODO Auto-generated method stub
		return messageDao.insert(message);
	}

	public Message getLast() {
		return messageDao.getLast();
	}
	
	public int getLastId() {
		return messageDao.getLast().getId();
	}

}
