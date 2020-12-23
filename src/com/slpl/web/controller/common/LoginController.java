package com.slpl.web.controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;
import com.slpl.web.service.member.MemberService;

@WebServlet("/common/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnURL = request.getParameter("return-url");   // 멤버변수 안됨. 요청 끝나면 서블릿 사라짐
		if(returnURL != null) {
			request.setAttribute("returnUrl", returnURL);    		 // 다른 페이지에서 넘어온 경우 돌아갈 url을  받음. jsp에서 hidden으로 post로 보내줄것
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);

		System.out.println("@ get - returnURL : "+returnURL);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 자바스크립트에서 검증을 끝내고 돌아옴
		// 로그인 컨트롤러에서는 파라미터 값을 확인해서 세션에 넣어주는거
		
		String loginId = request.getParameter("loginId");
		String pw = request.getParameter("pw");

		if(loginId == null || loginId.equals("") == true
				|| pw == null || pw.equals("") == true ) {
			return;
		}
		
		HttpSession session = request.getSession();			// true : 세션이 없을경우 생성, false : 세션이 없을경우 생성안함
		MemberService service = new MemberService();
		
		Member m = service.get(loginId);
		System.out.println("name : "+m.getName());
		
		MemberView mv = service.getView(m.getId());
		String categoryName = mv.getCategoryName();
		
		session.setAttribute("login", m);
		session.setAttribute("role", "user");
		session.setAttribute("categoryName", categoryName);
		
		String returnURL = request.getParameter("return-url");
		System.out.println("@ post - returnURL : "+returnURL);
		if(returnURL != null && !returnURL.equals("")) { 	// 로그인으로 돌려버린애가 어디로 갈지 알려줘야함
			response.sendRedirect(returnURL);
		} else {   // 돌아갈 곳이 없음
			response.sendRedirect("../test/list/test_list");   // 일단 테스트 페이지
		}
		
	}
}
