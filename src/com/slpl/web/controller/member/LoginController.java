package com.slpl.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.service.member.MemberService;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId = request.getParameter("logiId");
		String pw = request.getParameter("pw");
		
		MemberService service = new MemberService();
		Member m = service.get(loginId, pw);
		if(m != null) {
			
		}
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("m", m);

		response.sendRedirect("main.jsp");
	}
}
