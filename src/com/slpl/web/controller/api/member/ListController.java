package com.slpl.web.controller.api.member;

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
import com.slpl.web.service.member.MemberService;

@WebServlet("/api/admin/member/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");      
	    response.setContentType("text/json; charset=UTF-8");

		int pageScopeCount = MemberContext.PAGE_SCOPE_COUNT;
		int pageItemCount = MemberContext.PAGE_ITEM_COUNT;

		MemberService service = new MemberService();
		
	    int page = 1;
	    String page_ = request.getParameter("page");
	    if(page_ != null && page_.equals("") == false) {
	    	page = Integer.parseInt(page_);
	    }


	    int allCount = 0;
	    List<MemberView> list = new ArrayList<MemberView>();
		
	    String field = request.getParameter("field");
		String query = request.getParameter("query");
		
		if(field != null && query != null) {   //검색임
		    allCount = service.getViewList(field, query).size();
			list = service.getViewList(page, pageItemCount, field, query);
		} else {
		    allCount = service.getViewList().size();
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
			MemberView m = list.get(i);
			jsonList += String.format(
					"{\"id\":\"%s\",\"loginId\":\"%s\",\"name\":\"%s\",\"nickname\":\"%s\","+
					"\"authority\":\"%s\",\"categoryName\":\"%s\",\"email\":\"%s\","+
					"\"regdate\":\"%s\"}",
					m.getId(), m.getLoginId(), m.getName(), m.getNickname(), m.getAuthority(),
					m.getCategoryName(), m.getEmail(), m.getRegdate());
			
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
