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
		String[] checkCategory = request.getParameterValues("checkCategory");
		String page_ = request.getParameter("p");
		
		
//		int[] ids = null;
//		if(checkCategory == null) {
//			ids = null;
//			
//		}
		
		System.out.println(checkCategory[1]);
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		
//		  if(checkCategory != null) {
//			  ids = new int[checkCategory.length];
//		         for(int i=0 ; i<ids.length ; i++) {
//		            ids[i] = Integer.parseInt(checkCategory[i]);
//		            
//		            System.out.println(ids[i]);
//		         }
//		        
//		      }  
		  	 List<CommunityNoticeView> list= service.getViewList(page);
	         request.setAttribute("list", list);
		  
				/*
				 * if(checkIds != null) { int[] ids = new int[checkIds.length]; for(int i=0 ;
				 * i<ids.length ; i++) { ids[i] = Integer.parseInt(checkIds[i]); }
				 * 
				 * service.insertAll(title, content, ids); }
				 */
		  
		  
		  
//		  String[] checkIds = request.getParameterValues("checkMember");      
//
//	      if(checkIds != null) {
//	         int[] ids = new int[checkIds.length];
//	         for(int i=0 ; i<ids.length ; i++) {
//	            ids[i] = Integer.parseInt(checkIds[i]);
//	         }

		int count = service.getNoticeCount();
		//List<CommunityNoticeView> list= service.getViewList(page); 
		
		//List<CommunityNoticeView> list= service.getViewList(page,ids);    
		//List<CommunityNoticeView> list= service.getViewList(ids,);
//		List<CommunityNoticeView> list= service.getViewList(category, startindx, endindx);
		
		request.setAttribute("count", count);
		request.getRequestDispatcher("/admin/community/notice/list.jsp").forward(request, response);
	}

}
