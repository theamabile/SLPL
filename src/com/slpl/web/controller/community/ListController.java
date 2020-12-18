package com.slpl.web.controller.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityNoticeView;
import com.slpl.web.entity.community.CommunityView;
import com.slpl.web.service.community.CommunityNoticeService;
import com.slpl.web.service.community.CommunityService;
@WebServlet("/community/all/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityService service = new CommunityService();
		CommunityNoticeService noticeService = new CommunityNoticeService();
		
		String query_ = request.getParameter("q");
		String field_ = request.getParameter("f");
		String page_ = request.getParameter("p");
		
		String field = "title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		
		List<CommunityView> list= service.getViewList(field,query,page);
		List<CommunityNoticeView> notice = noticeService.getViewList(categoryId);
		int count = service.getCommunityCount(field, query);
		System.out.println(list);
		
		request.setAttribute("notice", notice);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		System.out.println("-================="+field+query+page+count);
		request.getRequestDispatcher("/community/all/list.jsp").forward(request, response);
	}

}
