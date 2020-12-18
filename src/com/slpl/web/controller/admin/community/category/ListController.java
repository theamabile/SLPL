package com.slpl.web.controller.admin.community.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityCategory;
import com.slpl.web.service.community.CommunityCategoryService;

@WebServlet("/admin/community/category/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommunityCategoryService service = new CommunityCategoryService();
		
		List<CommunityCategory> list= service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/community/category/list.jsp").forward(request, response);
	}

}
