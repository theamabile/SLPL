package com.slpl.web.board.all;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/all/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("boardId"));
		
		ListService service = new ListService();
		
		Board n= service.getDetail(id);
		System.out.println(n);
		
		request.setAttribute("n", n);
		request.getRequestDispatcher("/board/all/detail.jsp").forward(request, response);
		
		
	}

}
