package com.slpl.web.controller.admin.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;
import com.slpl.web.service.member.AdminService;
import com.slpl.web.service.member.MemberService;

@WebServlet("/admin/common/login")
public class LoginController extends HttpServlet {
	AdminService service;
	MemberService memberService;
	
	public LoginController() {
		service = new AdminService();
		memberService = new MemberService();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnURL = request.getParameter("return-url");   // 멤버변수 안됨. 요청 끝나면 서블릿 사라짐
		request.setAttribute("returnUrl", returnURL);    		 // 다른 페이지에서 넘어온 경우 돌아갈 url을  받음. jsp에서 hidden으로 post로 보내줄것
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId = request.getParameter("loginId");
		String pw = request.getParameter("pw");

		HttpSession session = request.getSession();			// true : 세션이 없을경우 생성, false : 세션이 없을경우 생성안함
		MemberView mv = null;
		int adminId = 0;
		if(memberService.isValid(loginId, pw)) {
			mv = memberService.getView(loginId);
			if(mv != null) {
				adminId = mv.getId();
			} 
		}
		
		if(service.isValid(adminId)) {  // 어드민 테이블에 존재하면 
			Member m = mv;
			session.setAttribute("login", m);
			session.setAttribute("role", "admin");
			session.setAttribute("categoryName", mv.getCategoryName());
			
			String returnURL = request.getParameter("return-url");
			if(returnURL != null && !returnURL.equals("")) { 	// 로그인으로 돌려버린애가 어디로 갈지 알려줘야함
				response.sendRedirect(returnURL);
			} else {   // 돌아갈 곳이 없음
				response.sendRedirect("../member/list");   // 일단 테스트 페이지
			}
		} 
	}
}
