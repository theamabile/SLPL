package com.slpl.web.controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.service.member.MemberService;

@WebServlet("/common/logout")
public class LogoutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();			// true : 세션이 없을경우 생성, false : 세션이 없을경우 생성안함
	
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
			session.removeAttribute("role");
		}
		
		response.sendRedirect("login");
	}
	
}
