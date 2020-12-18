package com.slpl.web.controller.admin.community.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityNotice;
import com.slpl.web.service.community.CommunityNoticeService;

@WebServlet("/admin/community/notice/reg")
public class RegController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityNoticeService service = new CommunityNoticeService();
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		else if (request.getMethod().equals("POST")) {
			//1.사용자 입력을 변수에 담기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			CommunityNotice reg = new CommunityNotice(title,content);
			
			
			 String[] checkIds = request.getParameterValues("checkCategory");      

		      if(checkIds != null) {
		         int[] ids = new int[checkIds.length];
		         for(int i=0 ; i<ids.length ; i++) {
		            ids[i] = Integer.parseInt(checkIds[i]);
		         }
		         
		         service.insertAll(title, content, ids);
		      }
//			
//			//2.데이터베이스에 입력
//			
//			service.insert(reg);
//			System.out.println("출력"+title+content);
		      response.sendRedirect("list");
		}
		
	}
	

}