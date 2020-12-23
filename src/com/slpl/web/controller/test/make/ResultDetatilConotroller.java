package com.slpl.web.controller.test.make;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.service.test.CharacterService;
import com.slpl.web.service.test.TestService;
import com.slpl.web.entity.test.Character;

@WebServlet("/test/make/result-detail")
public class ResultDetatilConotroller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("id"));
		CharacterService service = new CharacterService();
		Character c = service.get(id);
		
		request.setAttribute("name", c.getName());
		request.setAttribute("img", c.getImg());
		request.setAttribute("content", c.getContent());
		
		request.getRequestDispatcher("resultDetail.jsp").forward(request, response);
		
	}
}
