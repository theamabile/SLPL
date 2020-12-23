package com.slpl.web.board.all;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/board/all/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		ListService service = new ListService();
		
		List<Board> list= service.getList();
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/all/list.jsp").forward(request, response);
	}

}
