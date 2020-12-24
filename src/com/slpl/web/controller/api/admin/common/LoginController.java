package com.slpl.web.controller.api.admin.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.dao.jdbc.MemberContext;
import com.slpl.web.entity.member.Admin;
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;
import com.slpl.web.service.member.AdminService;
import com.slpl.web.service.member.MemberService;

@WebServlet("/api/admin/common/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");      
	    response.setContentType("text/json; charset=UTF-8");

	    String loginId = request.getParameter("loginId");
		String pw = request.getParameter("pw");
		System.out.println("loginId : "+loginId+" / pw : "+pw);
		
		boolean result = false;
		
		AdminService service = new AdminService();
		MemberService memberService = new MemberService();
		
		Member m = null;
		int adminId = 0;
		if(memberService.isValid(loginId, pw)) {
			m = memberService.getView(loginId);
			if(m != null) {
				adminId = m.getId();
			} 
		}
		
		if(service.isValid(adminId)) {  // 어드민 테이블에 존재하면 
			result = true;
		} 
	    
	    // =================================================================================================
		String json = "{\"result\":\""+result+"\"}";
	
	    System.out.println("json : "+json);
		response.getWriter().println(json);
		
	}
	
}
