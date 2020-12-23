package com.slpl.web.controller.test.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.test.TestListView;
import com.slpl.web.service.test.TestListViewService;

@WebServlet("/test/mypage/make_list")
public class TestListController extends HttpServlet{
		
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestListViewService service = new TestListViewService();
		HttpSession session = request.getSession();		
		
		String page_ = request.getParameter("p"); //페이지
		String key_ = request.getParameter("k"); // 검색어
		String cate = request.getParameter("c"); // 검색 분류
		String align_ = request.getParameter("a"); //정렬 기준
		
		
		Member m = (Member)session.getAttribute("login");
		
		int writerId = m.getId(); 
		int page = 1;
		int pl = 12;
		String key = key_;
		String align = "REGDATE";
		
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		
		//검색어 미입력시 카테고리 초기화 입력시 키에 %추가
		if(key_ == null || key_.equals("")) {
			cate = null;
		} else {
			key = "%"+key_+"%";
		}
		
		if(align_ !=null && !align_.equals(""))
			align = align_;
		
			
		
		List<TestListView> list = service.myList(page, pl, cate, key, align, writerId);
				
		request.setAttribute("list", list);
		request.getRequestDispatcher("make_list.jsp").forward(request, response);
	}
	
	
	
	
	
}