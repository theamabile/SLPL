package com.slpl.web.controller.test.make;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/make/reg-question")
public class RegQuestonConotroller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");      
		response.setContentType("text/json; charset=UTF-8");

//		String testName=request.getParameter("test-name");
//		String [] type = request.getParameterValues("types");
//		
//		System.out.println(testName);
//		System.out.println(type[0]);
	}

}
