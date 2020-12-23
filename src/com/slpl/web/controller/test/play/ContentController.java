package com.slpl.web.controller.test.play;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.slpl.web.entity.test.TestPlayView;
import com.slpl.web.service.test.TestPlayService;

@WebServlet("/test/play/content")
public class ContentController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");

		TestPlayService service = new TestPlayService();
		String qId_ = request.getParameter("qId");
		String id_ = request.getParameter("id");
		String[] answerValueArray = request.getParameterValues("answerVal");

		// 세션에 값 담기
		HttpSession session = request.getSession();

		session.setAttribute("answerVal", answerValueArray);
		String[] sessionVal = (String[]) session.getAttribute("answerVal");
		for(int j=0; j<sessionVal.length; j++) {
			for(int i=0; i<answerValueArray.length; i++) {
				System.out.printf("session:%s\n answerVal:%s\n",sessionVal[i], answerValueArray[i]);
				System.out.printf("session:%s\n answerVal:%s\n",sessionVal[i], answerValueArray[i]);
			}			
		}

		int id = 1;
		int qId = 1;
		if (id_ != null && !id_.equals(""))
			id = Integer.parseInt(id_);
		if (qId_ != null && !qId_.equals(""))
			qId = Integer.parseInt(qId_);

		List<TestPlayView> list = service.getList(id, qId);
		String json = new Gson().toJson(list);
		response.getWriter().println(json);
	}
}
