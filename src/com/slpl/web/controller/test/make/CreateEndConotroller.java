package com.slpl.web.controller.test.make;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.test.Test;
import com.slpl.web.service.test.TestService;

@WebServlet("/test/make/create-end")
public class CreateEndConotroller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int memberId = 0;
		int testId = 0;
		
		TestService service = new TestService();
		
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");

		if (m != null)
			memberId = m.getId();

		if (cookies != null) {
			for (Cookie cookie : cookies)
				if ("testId".equals(cookie.getName())) {
					testId = Integer.parseInt(cookie.getValue());
				}
		}
		Test t = service.get(testId);
		
		String nickname = m.getNickname();
		String testName = t.getName();
		
		System.out.println("testName:" +testName);
		System.out.println("nickName:" +nickname);
		
		request.setAttribute("nickName", nickname);
		request.setAttribute("testName", testName);
		
		request.getRequestDispatcher("/test/make/createEnd.jsp").forward(request, response);
		
		
	}
}
