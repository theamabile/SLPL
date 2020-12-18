package com.slpl.web.controller.admin.community.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityCategory;
import com.slpl.web.service.community.CommunityCategoryService;

@WebServlet("/admin/community/category/category_add")
public class RegController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("category_add.jsp").forward(request, response);
		else if (request.getMethod().equals("POST")) {
			//1.사용자 입력을 변수에 담기
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			CommunityCategory reg = new CommunityCategory(id,name);
			
			//2.데이터베이스에 입력
			CommunityCategoryService service = new CommunityCategoryService();
			service.insert(reg);
			System.out.println("출력"+id+name);
			
		}
		//response.sendRedirect("list");
	}
	

}