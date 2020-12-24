package com.slpl.web.controller.api.common;

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
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;
import com.slpl.web.service.member.MemberService;

@WebServlet("/api/common/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");      
	    response.setContentType("text/json; charset=UTF-8");

	    String loginId = request.getParameter("loginId");
		String pw = request.getParameter("pw");

		MemberService service = new MemberService();
		
		boolean result = false;
		
		if(service.isValid(loginId, pw)) {
			result = true;
		} 
	    
	    // =================================================================================================
		String json = "{\"result\":\""+result+"\"}";
	
	    System.out.println("json : "+json);
		response.getWriter().println(json);
		
	}
	
}
