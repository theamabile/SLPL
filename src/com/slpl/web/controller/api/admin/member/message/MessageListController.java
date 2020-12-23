package com.slpl.web.controller.api.admin.member.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.dao.jdbc.MemberContext;
import com.slpl.web.entity.member.MemberView;
import com.slpl.web.entity.member.MessageSendView;
import com.slpl.web.service.member.MemberService;
import com.slpl.web.service.member.MessageSendService;

@WebServlet("/api/admin/member/message/list")
public class MessageListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");      
	    response.setContentType("text/json; charset=UTF-8");

		int pageScopeCount = MemberContext.PAGE_SCOPE_COUNT;
		int pageItemCount = MemberContext.PAGE_ITEM_COUNT;

		int page = 1;
		String page_ = request.getParameter("page");
		if(page_ != null && page_.equals("") == false) {
	    	page = Integer.parseInt(page_);
	    }
		
		MessageSendService service = new MessageSendService();
		List<MessageSendView> list = new ArrayList<MessageSendView>();

	    String field = request.getParameter("field");
		String query = request.getParameter("query");
		
		boolean isSender = true;
		int senderId = 1;   // 로그인 기능 전이라 상수로 넣어둠
		
		int allCount = 0;
		if(field != null && query != null) {   //검색임
			allCount = service.getViewList(field, query).size();   //검색 결과에 대한 전체 count 갖고오기
			list = service.getViewList(page, pageItemCount, field, query);
		} else {
			allCount = service.getViewList().size();   //전체 목록 수
			list = service.getViewList(page, pageItemCount);
		}
	    
		// =================================================================================================
	    String jsonHeader = "\"header\":";
	    
	    if(field != null && query != null) {   //검색임
	    	 jsonHeader += String.format("{\"allCount\":\"%s\",\"pageScopeCount\":\"%s\",\"pageItemCount\":\"%s\""
	    	 		+ ",\"field\":\"%s\",\"query\":\"%s\"}"
						,allCount, pageScopeCount, pageItemCount, field, query);
	    } else {
	    	 jsonHeader += String.format("{\"allCount\":\"%s\",\"pageScopeCount\":\"%s\",\"pageItemCount\":\"%s\"}"
						,allCount, pageScopeCount, pageItemCount);
	    }
	    
		// 데이터를 사용자에게 보내주기
		String jsonList = "\"list\": [";
		for(int i=0 ; i<list.size(); i++) {
			MessageSendView m = list.get(i);
			jsonList += String.format(
					"{\"id\":\"%s\",\"type\":\"%s\",\"title\":\"%s\",\"senderName\":\"%s\",\"receiverName\":\"%s\",\"regdate\":\"%s\"}",
					m.getId(), m.getType(), m.getTitle(), m.getSenderName(), m.getReceiverName(), m.getRegdate());

			if(list.size() > i+1) {
				jsonList += ",";
			}
		}
		
		jsonList += "]";

	    String json = "{";
	    json += jsonHeader;
	    json += ",";
	    json += jsonList;
		json += "}";
		
		response.getWriter().println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		int pageScopeCount = MemberContext.PAGE_SCOPE_COUNT;
		int pageItemCount = MemberContext.PAGE_ITEM_COUNT;
		
	   	String json = String.format("{\"pageScopeCount\":\"%s\",\"pageItemCount\":\"%s\"}"
						, pageScopeCount, pageItemCount);
	   	
	   	response.getWriter().println(json);
	    
	}
	
}
