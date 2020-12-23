package com.slpl.web.controller.test.list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.TestListView;
import com.slpl.web.service.test.TestListViewService;

@WebServlet("/test/list/test_list")
public class TestListController extends HttpServlet{
		
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestListViewService service = new TestListViewService();
		String page_ = request.getParameter("p"); //페이지
		String key_ = request.getParameter("k"); // 검색어
		String cate = request.getParameter("c"); // 검색 분류
		String align_ = request.getParameter("a"); //정렬 기준
		
		
		int page = 1;
		int pl = 8;
		String key = key_;
		String align = "REGDATE";
		String order = "DESC";
		
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
		
			
		
		List<TestListView> list = service.getList(page, pl, cate, key, align, order);
		List<TestListView> bestList_ = service.bestList();
		List<TestListView> bestList = new ArrayList<>();

		Collections.shuffle(bestList_);
		
		for(int i=0; i<10; i++) {
			bestList.add(bestList_.get(i));
		}
		
		request.setAttribute("list", list);
		request.setAttribute("bestList", bestList);
		request.getRequestDispatcher("test_list.jsp").forward(request, response);
	}
	
	
	
	
	
}