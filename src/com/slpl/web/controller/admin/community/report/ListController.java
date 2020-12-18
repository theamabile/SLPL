package com.slpl.web.controller.admin.community.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityReportView;
import com.slpl.web.service.community.CommunityReportService;

@WebServlet("/admin/community/report/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommunityReportService service = new CommunityReportService();
		
		String page_ = request.getParameter("p");
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_) ;
		}
		
		int count = service.getReportCount();
		List<CommunityReportView> list= service.getViewList(page);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/admin/community/report/list.jsp").forward(request, response);
	}

}
