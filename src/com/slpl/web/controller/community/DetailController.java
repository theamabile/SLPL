package com.slpl.web.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommentReg;
import com.slpl.web.entity.community.Community;
import com.slpl.web.service.community.CommunityService;


@WebServlet("/community/all/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
//		String conten
		
		CommunityService service = new CommunityService();
		
		Community n= service.getDetail(id);
		
//		CommentReg replyR = service.commentInsert(id,)
		
		
		request.setAttribute("n", n);
		request.getRequestDispatcher("/community/all/detail.jsp").forward(request, response);
		
		
	}

}
