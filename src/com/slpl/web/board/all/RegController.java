package com.slpl.web.board.all;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/all/write")
public class RegController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("write.jsp").forward(request, response);
		else if (request.getMethod().equals("POST")) {
			//1.사용자 입력을 변수에 담기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(title+content);
			Board board = new Board(title,content);
			
			//2.데이터베이스에 입력
			ListService service = new ListService();
			service.insert(board);
			
			//목록페이지로 이동
			response.sendRedirect("/board/all/list");
		}
	}
	

}
