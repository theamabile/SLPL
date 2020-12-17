package com.slpl.web.dao.member;

import java.util.List;

import com.slpl.web.entity.member.MessageSend;
import com.slpl.web.entity.member.MessageSendView;

public interface MessageSendDao {
	int insert(MessageSend ms);   // 메세지 전송
	MessageSend get(int id);
	List<MessageSend> getList();
	
	// ======================================= View ==========================================
	MessageSendView getView(int id);
	List<MessageSendView> getViewList(); 
	List<MessageSendView> getViewList(boolean isSender, int memberId, int startIndex, int endIndex, String field, String query);

}
