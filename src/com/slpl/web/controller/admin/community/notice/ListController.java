package com.slpl.web.controller.admin.community.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityNoticeView;
import com.slpl.web.service.community.CommunityNoticeService;

@WebServlet("/admin/community/notice/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommunityNoticeService service = new CommunityNoticeService();
		//String[] checkCategory = request.getParameterValues("checkCategory");  
		String page_ = request.getParameter("p");
		System.out.println("페이지"+page_);
		
		//System.out.println(checkCategory);
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_) ;
		}
//		int[] ids = null;
//		  if(checkCategory != null) {
//			  ids = new int[checkCategory.length];
//		         for(int i=0 ; i<ids.length ; i++) {
//		            ids[i] = Integer.parseInt(checkCategory[i]);
//		         }
		         
		         //service.deleteAll(ids);
		         
		     // }  

		int count = service.getNoticeCount();
		List<CommunityNoticeView> list= service.getViewList(page); 
		
		//List<CommunityNoticeView> list= service.getViewList(page,checkCategory);    
		//List<CommunityNoticeView> list= service.getViewList(ids,);
//		List<CommunityNoticeView> list= service.getViewList(category, startindx, endindx);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/admin/community/notice/list.jsp").forward(request, response);
	}

}
