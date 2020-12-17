package com.slpl.web.controller.admin.member;

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


@WebServlet("/admin/member/messageDetail")
public class MessageDetailController extends HttpServlet {
	
	MessageSendService service;
	AdminService adminService;
	
	public MessageDetailController() {
		service = new MessageSendService();
		adminService = new AdminService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		MessageSendView m = service.getView(id);
		
		request.setAttribute("message", m);
		request.getRequestDispatcher("message_detail.jsp").forward(request, response);
	}
	
}
