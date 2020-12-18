package com.slpl.web.controller.admin.test.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.TestListView;
import com.slpl.web.service.test.TestListViewService;

@WebServlet("/admin/test/list/test-list")
public class TestListController extends HttpServlet{
		
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestListViewService service = new TestListViewService();
		String page_ = request.getParameter("p"); //페이지
		String pl_ = request.getParameter("pl"); // 한화면에 나오는 페이지 갯수
		String key_ = request.getParameter("k"); // 검색어
		String cate = request.getParameter("c"); // 검색 분류
		String align_ = request.getParameter("a"); //정렬 기준
		String order_ = request.getParameter("o"); //정렬 방법
		
		
		
		int page = 1;
		int pl = 10;
		String key = key_;
		String align = "REGDATE";
		String order = "DESC";
		
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		if(pl_ != null && !pl_.equals(""))
			pl = Integer.parseInt(pl_);
		
		//검색어 미입력시 카테고리 초기화 입력시 키에 %추가
		if(key_ == null || key_.equals("")) {
			cate = null;
		} else {
			key = "%"+key_+"%";
		}
		
		if(align_ !=null && !align_.equals(""))
			align = align_;
		
		if(order_ !=null && !order_.equals(""))
			order = order_;
		
			
		
		List<TestListView> list = service.getList(page, pl, cate, key, align, order);
		System.out.println("요기까진됨");
		request.setAttribute("list", list);
		request.getRequestDispatcher("test-list.jsp").forward(request, response);
	}
	
	
	
	
	
}
