package com.slpl.web.controller.admin.community.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.Community;
import com.slpl.web.entity.community.CommunityNotice;
import com.slpl.web.service.community.CommunityNoticeService;
import com.slpl.web.service.community.CommunityService;



@WebServlet("/admin/community/notice/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// 서비스 선언
		CommunityNoticeService service = new CommunityNoticeService();
		CommunityNotice n = service.getList(id);

		request.setAttribute("n", n);
		request.getRequestDispatcher("/community/all/update.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Community community = new Community(title,content);
		community.setId(Integer.parseInt(id));
		
		CommunityService service = new CommunityService();
		service.update(community);
		
		response.sendRedirect("detail?id="+id);

	}

}
