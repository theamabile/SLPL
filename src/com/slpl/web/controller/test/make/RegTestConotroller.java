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
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.test.Test;
import com.slpl.web.service.test.TestService;
import com.slpl.web.service.test.TypeService;

@WebServlet("/test/make/reg-test")
public class RegTestConotroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		임시 아이디
		int memberId = 4;
		int formLevelId = 1;

		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		
		if(m!=null)
			memberId=m.getId();

		String testId_ = request.getParameter("testId");
		int testId = 0;
		String testName = request.getParameter("test-name");
		String[] type = request.getParameterValues("types");

//		테스트 등록
		TestService service = new TestService();
		Test t;
//		새로등록
		if(testId_==null) {
			 t = new Test();
			t.setMemberId(memberId);
			t.setName(testName);
			t.setPublicState(0);
			t.setFormLevelId(formLevelId);
			testId = service.insert(t);
		}
//		수정
		else {
			testId = Integer.parseInt(testId_);
			t=service.get(testId);
			t.setName(testName);
			service.update(t);
		}
//		테스트 성향 등록
		TypeService typeService = new TypeService();
		int [] typeId = new int[type.length];
		for (int i = 0; i < type.length; i++)
			typeId[i]=typeService.insert(testId,type[i]);
		

		
//		쿠키로 테스트 정보 넘겨주기
		Cookie testCookie = new Cookie("testId", String.valueOf(testId));
		Cookie memberCookie = new Cookie("memberId", String.valueOf(testId));
//		성향 배열 쿠키 인코딩
		Cookie typeIdsCookie = new Cookie("typeIds", URLEncoder.encode(Arrays.toString(typeId), "UTF-8")); 


		testCookie.setMaxAge(60 * 60);
		typeIdsCookie.setMaxAge(60 * 60);
//		cookie가 제작에서만 사용되도록 경로 지정
		testCookie.setPath("/test/make/");
		typeIdsCookie.setPath("/test/make/");
		
//		Cookie typeIdsCookie = new Cookie("typeIds", Arrays.toString(typeId));
		response.addCookie(testCookie);
//		response.addCookie(memberCookie);
		response.addCookie(typeIdsCookie);
		
		
		//A서블릿이 이용하던 것을 B 서블릿이 바로 이어서 사용하도록.
		request.getRequestDispatcher("/test/make/test.jsp").forward(request, response);
//		response.sendRedirect("/test/make/reg-question?testId="+testId+"&memberId="+memberId);
		
	}

}
