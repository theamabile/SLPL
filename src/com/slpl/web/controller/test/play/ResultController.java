package com.slpl.web.controller.test.play;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.TestResultView;
import com.slpl.web.service.test.TestResultService;

@WebServlet("/test/play/result")
public class ResultController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TestResultService service = new TestResultService();
		String id_ = request.getParameter("id");
		System.out.println("resultId:"+id_);
		int id = 1;	
		if (id_ != null && !id_.equals(""))
			id = Integer.parseInt(id_);
			
		List<TestResultView> list = service.getList(id);
		
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
