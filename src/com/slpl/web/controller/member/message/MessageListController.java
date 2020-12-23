package com.slpl.web.controller.member.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.dao.jdbc.MemberContext;
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MessageSendView;
import com.slpl.web.service.member.MessageSendService;

@WebServlet("/member/message/list")
public class MessageListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MessageSendService service = new MessageSendService();
		
		// 로그인 정보 가져오기
		Member loginMember = (Member) request.getSession().getAttribute("login");
		boolean isSender = false;
		int receiverId = loginMember.getId();   // 로그인 기능 전이라 상수로 넣어둠
		
		System.out.println("receiverId : "+receiverId);
		List<MessageSendView> list = new ArrayList<MessageSendView>();
		
		
		int pageCount = MemberContext.PAGE_SCOPE_COUNT;
		int itemCount = MemberContext.PAGE_ITEM_COUNT;
		
		int allCount = 0;   	// 전체 리스트 항목 수
		int allPageCount = 1;   // 전체 페이지 갯수
		int restCount = 0;      // 마지막 페이지의 아이템 항목 수
		int startPage = 1;		// 전환 가능한 페이지 범위 시작
		int endPage = 1;		// 전환 가능한 페이지 범위 끝  (2페이지일 경우 1~5의 페이지를 리스트로 전시. 이때 5를 말함)
		int currentPage = 1;    // 검색 일 경우 1페이지
		
		//  파라미터 가져오기
		String pageParam = request.getParameter("page");
		if(pageParam != null ) {	// list url로 바로 들어 왔을 경우(page parameter가 없음)
			currentPage = Integer.parseInt(pageParam);
		}
		String field = request.getParameter("field");
		String query = request.getParameter("query");
		
		if(field != null && query != null) {   //검색임
			allCount = service.getViewList(isSender, receiverId, field, query).size();   //검색 결과에 대한 전체 count 갖고오기
			if(allCount > 0) {
				// 전체 페이지 수 계산
				allPageCount = allCount / itemCount;
		        restCount = allCount % itemCount;
		        if( restCount > 0 ) {
		        	allPageCount += 1;
		        }
		        
		        // 현재 페이지에 대한 페이지 범위 산출
		        startPage = ( pageCount * ((currentPage-1)/pageCount) ) + 1;
		        endPage = startPage + pageCount-1;
		        if(endPage > allPageCount) {   // 만약 전체 페이지 수 보다 전시할 끝 페이지 수가 크면
		        	endPage = allPageCount;
		        }
			}
			
			// 검색 결과에 맞는 정보 가져오기
			list = service.getViewList(isSender, receiverId, currentPage, itemCount, field, query);
			System.out.println(currentPage+"쪽 / "+itemCount+" / getViewList 갯수 - "+list.size());
			boolean searchResult = false;
			if(list.size() > 0) {
				searchResult = true;
			}

			request.setAttribute("field", field);
			request.setAttribute("query", query);
			request.setAttribute("searchResult", searchResult);
			
		} else {    // 낫 검색
			allCount = service.getViewList(isSender, receiverId).size();   //전체 목록 수
			
			// 페이지에 맞는 정보 가져오기
			list = service.getViewList(isSender, receiverId, currentPage, itemCount);
			
	        // 전체 페이지 수 계산
	        allPageCount = allCount / itemCount;
	        restCount = allCount % itemCount;
	        if( restCount > 0 ) {
	        	allPageCount += 1;
	        }
	        
	        // 현재 페이지에 대한 페이지 범위 산출
	        startPage = ( pageCount * ((currentPage-1)/pageCount) ) + 1;
	        endPage = startPage + pageCount-1;
	        if(endPage > allPageCount) {   // 만약 전체 페이지 수 보다 전시할 끝 페이지 수가 크면
	        	endPage = allPageCount;
	        }
		}
		
	
        
    	System.out.println("ㅎ 현재 페이지 - "+ currentPage +" / size():"+allCount+" / 현재 페이지 아이템 : "+list.size()+" / 나머지 : "+restCount 
			    			+ " / 페이지 총 수 : "+allPageCount + " / 페이지 범위 : "+startPage+"~"+endPage 
			    			+ " / itemCount : "+itemCount+" / pageCount : "+pageCount);
    	
    	request.setAttribute("currentPage", currentPage);
		request.setAttribute("allPageCount", allPageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}
