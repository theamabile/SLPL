package com.slpl.web.controller.admin.test.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.TestReport;
import com.slpl.web.service.test.TestReportService;

@WebServlet("/admin/test/report/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestReportService service = new TestReportService();
		int id = Integer.parseInt(request.getParameter("id"));
		//String keyword = request.getParameter("keyword");
		TestReport r = service.getDetail(id);
		
		request.setAttribute("r", r);

		request.getRequestDispatcher("detail.jsp").forward(request, response);			
	}
}
