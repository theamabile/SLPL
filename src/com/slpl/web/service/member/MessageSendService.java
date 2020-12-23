package com.slpl.web.service.member;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcMessageSendDao;
import com.slpl.web.dao.jdbc.MemberContext;
import com.slpl.web.dao.member.MessageSendDao;
import com.slpl.web.entity.member.MessageSend;
import com.slpl.web.entity.member.MessageSendView;

public class MessageSendService {

	// 여기서 생성자 안만들고 외부로 뺄거임. 내부에 넣으면 결함력 강해짐.
	// 기업용은 보통 외부에 뺌. 완성인지 미완성인지 어떤거 쓸지 모르니까.
	public MessageSendDao sendDao;

	public MessageSendService() {
		sendDao = new JdbcMessageSendDao();
	}
	
	public int insert(MessageSend ms) {
		// TODO Auto-generated method stub
		return sendDao.insert(ms);
	}

	public List<MessageSend> getList() {
		// TODO Auto-generated method stub
		return sendDao.getList();
	}

	
	// ============================================== View ========================================================
	
	public MessageSendView getView(int id) {
		// TODO Auto-generated method stub
		return sendDao.getView(id);
	}
	
	// 모든 메세지 목록  - 페이징 X | 검색 X
	public List<MessageSendView> getViewList() {
		return sendDao.getViewList();
	}

	// 모든 메세지 목록 - 페이징 X | 검색 O
	public List<MessageSendView> getViewList(String field, String query) {
		int maxSize = sendDao.getViewList().size();
		return sendDao.getViewList(1, maxSize, field, query);	
	}
	
	// 모든 메세지 목록 - 페이징 O | 검색 X 
	public List<MessageSendView> getViewList(int page, int size) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		return sendDao.getViewList(startIndex, endIndex, null, null);
	}

	// 모든 메세지 목록 + 페이징 O | 검색 O
	public List<MessageSendView> getViewList(int page, int size, String field, String query) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		return sendDao.getViewList(startIndex, endIndex, field, query);	
	}
	
	
	
	// 발신자/수신자 별 목록 - 페이징 X | 검색 X
	public List<MessageSendView> getViewList(boolean isSender, int memberId) {
		int maxSize = sendDao.getViewList().size();
		return sendDao.getViewList(isSender, memberId, 1, maxSize, null, null);
	}

	// 발신자/수신자 별 목록 - 페이징 X | 검색 O
	public List<MessageSendView> getViewList(boolean isSender, int memberId, String field, String query) {
		int maxSize = sendDao.getViewList().size();
		return sendDao.getViewList(isSender, memberId, 1, maxSize, field, query);   // 검색 결과 전체
	}
	
	// 발신자/수신자 별 목록 - 페이징 O | 검색 X 
	public List<MessageSendView> getViewList(boolean isSender, int memberId, int page, int size) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		return sendDao.getViewList(isSender, memberId, startIndex, endIndex, null, null);
	}

	// 발신자/수신자 별 목록 + 페이징 O | 검색 O
	public List<MessageSendView> getViewList(boolean isSender, int memberId, int page, int size, String field, String query) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		return sendDao.getViewList(isSender, memberId, startIndex, endIndex, field, query);	
	}

}
