package com.slpl.web.controller.admin.test.best;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.MemberTestAvgView;
import com.slpl.web.entity.test.Test;
import com.slpl.web.service.TestAvgService;
import com.slpl.web.service.TestService;

@WebServlet("/admin/test/best/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		TestService service = new TestService();
		TestAvgService avgService = new TestAvgService();
		MemberTestAvgView avgView = new MemberTestAvgView();
		
		int id =Integer.parseInt(request.getParameter("id"));
		int memberId =Integer.parseInt(request.getParameter("memberId"));
		
		Test t=service.get(id);
		avgView = avgService.get(memberId);
		
		request.setAttribute("t", t);
		request.setAttribute("infor", avgView);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TestService service = new TestService();
		int id =Integer.parseInt(request.getParameter("id"));
		int memberId =Integer.parseInt(request.getParameter("memberId"));
		String reg = request.getParameter("reg");
		String coulumn = "BEST_STATE";
		
		//베스트 등록
		int result=0;
		if(reg.equals("best")){
			result = service.update(id,coulumn,1);
			
		}else {
			result =service.update(id,coulumn,0);
			
		}
		response.sendRedirect("detail?id="+id+"&memberId="+memberId);
		
		
	}

}
