package com.slpl.web.controller.test.make;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.service.test.CharacterService;
import com.slpl.web.entity.test.Character;

@WebServlet("/test/make/reg-result-name")
public class RegResultNameConotroller extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		int testId = 0;

//		테스트 정보 
		if (cookies != null) {
			for (Cookie cookie : cookies)
				if ("testId".equals(cookie.getName()))
					testId = Integer.parseInt(cookie.getValue());
		}
		
		String [] resultName = request.getParameterValues("result-name");
		int [] characterId = new int [resultName.length];
		
		
		System.out.println("test Id는  ?" + testId);
		CharacterService charService = new CharacterService();
		Character character;
		
		for(int i =0; i<resultName.length; i++) {
			character = new Character();
			character.setName(resultName[i]);
			character.setContent("결과 설명 없음");
			character.setTestId(testId);
			characterId[i] =charService.insert(character);
		}

		Cookie characterIdCookie = new Cookie("characterIds", URLEncoder.encode(Arrays.toString(characterId), "UTF-8"));

		characterIdCookie.setMaxAge(60 * 60);
		characterIdCookie.setPath("/test/make/");
		
		response.addCookie(characterIdCookie);
		
		
//		request.setAttribute("name", resultName);
		
		
		request.setAttribute("name1", resultName[0]);
		request.setAttribute("name2", resultName[1]);
		request.setAttribute("name3", resultName[2]);
		request.setAttribute("name4", resultName[3]);
		
		
		request.getRequestDispatcher("/test/make/test").forward(request, response);
		
			
		
	}
}
