package com.slpl.web.controller.member.message;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityCategory;
import com.slpl.web.entity.member.Admin;
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;
import com.slpl.web.entity.member.MessageSendView;
import com.slpl.web.service.member.AdminService;
import com.slpl.web.service.member.MemberService;
import com.slpl.web.service.member.MessageSendService;


@WebServlet("/member/message/detail")
public class MessageDetailController extends HttpServlet {
	
	MessageSendService service;
	
	public MessageDetailController() {
		service = new MessageSendService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		MessageSendView m = service.getView(id);
		
		request.setAttribute("message", m);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
	
}
