package com.slpl.web.controller.test.make;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.Test;
import com.slpl.web.service.TestService;

@WebServlet("/test/make/reg-test")
public class RegTestConotroller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setCharacterEncoding("UTF-8");      
//		response.setContentType("text/json; charset=UTF-8");

//		임시 아이디 -> 로그인한 데이터 얻어오기 추가예정
		int memberId = 1;
		int formLevel = 1;
		String testName=request.getParameter("test-name");
		String [] type = request.getParameterValues("types");
		
		System.out.println(testName);
		System.out.println(type[0]);
		
		TestService service = new TestService();
		Test t= new Test();
		t.setMemberId(memberId);
		t.setName(testName);
		t.setPublicState(0);
		
		int testId = service.insert(t);
		
		
	}

}
