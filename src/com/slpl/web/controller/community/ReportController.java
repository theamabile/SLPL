package com.slpl.web.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.community.CommunityCategory;
import com.slpl.web.entity.community.CommunityReport;
import com.slpl.web.service.community.CommunityCategoryService;
import com.slpl.web.service.community.CommunityReportService;

@WebServlet("/community/all/report")
public class ReportController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equals("GET")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			request.setAttribute("id", id);
			request.getRequestDispatcher("report.jsp").forward(request, response);
		}
			
		else if (request.getMethod().equals("POST")) {
			// 1.사용자 입력을 변수에 담기
			int id = Integer.parseInt(request.getParameter("id"));
			int reason = Integer.parseInt(request.getParameter("reason"));
			System.out.println("출력" + id + reason);
			CommunityReport reg = new CommunityReport(id, reason);

			// 2.데이터베이스에 입력
			CommunityReportService service = new CommunityReportService();
			service.insert(reg);

		}
		// response.sendRedirect("list");
	}

}