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
import com.sun.net.httpserver.Filter;

@WebServlet("/admin/test/report/list")
public class ListControllor extends HttpServlet {

	// get과 post 요청 다르게 컨트롤러 사용이 가능
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TestReportService service = new TestReportService();

		String page_ = request.getParameter("page");
		String key_ = request.getParameter("key");
		String keyword_ = request.getParameter("keyword");
		int page = 1;
		int size = 5;
		String key = null;
		String keyword = null;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
			
		if (request.getParameter("key") != null && request.getParameter("keyword") != null) {
			key = request.getParameter("key");
			keyword = request.getParameter("keyword");
		}
		//System.out.printf("page:%s, size:%s, key:%s, keyword:%s\n",page, size,key, keyword);
		if (request.getParameter("checkId") != null && request.getParameter("stateType") != null) {
			String[] checkIds = request.getParameterValues("checkId");
			for (int i = 0; i < checkIds.length; i++) {
				int checkId = Integer.parseInt(checkIds[i]);
				String stateType = request.getParameter("stateType");
				service.upState(checkId, stateType);
			}
		}

		List<TestReport> list = service.getList(page, size, key, keyword);

		request.setAttribute("list", list);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TestReportService service = new TestReportService();

		response.sendRedirect("list");
	}
}
