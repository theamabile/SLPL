package com.slpl.web.controller.api.admin.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.member.Member;
import com.slpl.web.service.member.MemberService;

@WebServlet("/api/admin/member/add")
public class AddController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");      
	    response.setContentType("text/json; charset=UTF-8");

		String field = request.getParameter("field");
		String query = request.getParameter("query");
		
		
		MemberService service = new MemberService();
		List<Member> list = service.getList(field, query);
		int count = list.size();
		
		// 데이터를 사용자에게 보내주기
		String json = String.format("[{\"field\":\"%s\",\"count\":%d}]", field, count);
		response.getWriter().println(json);
	}
}
