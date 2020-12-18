package com.slpl.web.controller.admin.test.best;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.Test;
import com.slpl.web.service.test.TestService;

@WebServlet("/admin/test/best/test")
public class listController extends HttpServlet {
	private int size = 10;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TestService service = new TestService();

		String align = request.getParameter("align");
		String bestState = request.getParameter("best-state");
		String keyword = request.getParameter("keyword");
		String page_ = request.getParameter("p");
		
		int page =1;
		if(page_ != null )
			page = Integer.parseInt(page_);
		
//		Map<String, Object> filter = new HashMap<String, Object>();
//		
//		filter.put("align", align_);
//		filter.put("bestState", bestState_);
//		filter.put("memberId", keyword_);
//		
//		String align = (String)filter.get("align");
//		String bestState = (String)filter.get("bestState");
//		String keyword =  (String)filter.get("memberId");
		
		
		List<Test> list ;
		if(keyword==null || keyword.equals("")) {
			list =service.getList(page,size,"BEST_STATE",bestState,align);	
		}else
			list =service.getList(page,size,"MEMBER_ID",keyword,"BEST_STATE",bestState,align);


		request.setAttribute("list", list);
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TestService service = new TestService();
		String[] bestStateIds_ = request.getParameterValues("check-state-id");
		String reg = request.getParameter("reg");
		String coulumn = "BEST_STATE";
		
//		id int 형으로 변환 
		int [] bestStateIds = new int[bestStateIds_.length];
		for(int i=0; i<bestStateIds_.length;i++) {
			bestStateIds[i]=Integer.parseInt(bestStateIds_[i]);
		}
		
		int result=0;
		if(reg.equals("best")){
			result = service.updateAll(bestStateIds,coulumn,1);
			
		}else {
			result =service.updateAll(bestStateIds,coulumn,0);
			
		}
		response.sendRedirect("test");
		

	}

}
