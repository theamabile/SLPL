package com.slpl.web.controller.test.play;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.TestPlayView;
import com.slpl.web.service.test.TestPlayService;

@WebServlet("/test/play/action")
public class ActionController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TestPlayService service = new TestPlayService();
		String id_ = request.getParameter("id");

		int id = 1;

		if (id_ != null && !id_.equals(""))
			id = Integer.parseInt(id_);

		List<TestPlayView> list = service.getStartList(id, "play");

		request.setAttribute("list", list);
		request.getRequestDispatcher("action.jsp").forward(request, response);
		
	}
}
