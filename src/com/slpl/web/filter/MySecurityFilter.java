package com.slpl.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slpl.web.entity.member.Member;

@WebFilter("/*")
public class MySecurityFilter implements Filter {
	
	// 인증이 필요한 url들
	private final static String[] authURLs = {
			"/admin/member/",        // 관리자 - 회원
			"/admin/community/",     // 관리자 - 게시판
			"/admin/test/",        	 // 관리자 - 게시판
			"/member/",      		 // 사용자 - 마이페이지
			"/community/", 			 // 사용자 - 게시판
			"/test/make/",			 // 사용자 - 테스트 제작
			"/test/mypage/"          // 사용자 - 테스트 결과 조회 
	};   
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		String uri = request.getRequestURI();
//		request.getRequestURI();  // 요청 경로에 프로토콜 제외 (ex:/member/login)
//		request.getRequestURL();  // 요청 경로에 프로토콜 포함 (ex:http://localhost:8080/member/login)
		
		//System.out.println("uri : "+uri);
		
		HttpSession session = request.getSession();
		
		if(!uri.contains("api") && !uri.contains("assets")) {  // 이거 왜 탈까 일단 예외처리 
			// 인증이 필요한 URL을 요청했나?
			boolean requireAuth = false;
			for(String url : authURLs) {
				// 사용자가 요청한 url에 인증이 필요한 url이 포함되어 있는가
				if(uri.contains("api") == false && uri.contains(url)) {   
					requireAuth = true;   // 인증이 필요하면 true하고 빠져나오기
					break;
				}
			}
			
			if(requireAuth) {
				// 로그인 필요 페이지가 아니거나 / 로그인 되어 있음
				boolean isAdminURL = false; 
				if(uri.contains("admin")) {
					isAdminURL = true;
				}
				
				// 인증 했는지 검사
				// 인증이 필요한 페이지와 안필요한 페이지 구분해야 함
				//  => 인증이 필요한데 인증 되어 있지 않으면 true
				//  => 인증 필요 없으면 false
				if(session.getAttribute("login") == null) {    // 세션에 로그인 정보가 없음
					// 모든 페이지 기준이라 절대 경로
					if(isAdminURL) {
						response.sendRedirect("/admin/common/login?return-url="+uri);   // 페이지 이동 될때마다 필터를 타서 여기서 계속 무한루프 탐 	
						System.out.println("어드민 로그인으로 ");
						return;
					} else { 
						response.sendRedirect("/common/login?return-url="+uri);   // 페이지 이동 될때마다 필터를 타서 여기서 계속 무한루프 탐 	
						System.out.println("사용자 로그인으로 ");
						return;
					}
				}
				
				
				if(isAdminURL) {   // 사용자 경로에 admin이 포함되어 있으면 = 관리자 페이지  
					if(!session.getAttribute("role").equals("admin")) {
						response.sendRedirect("/error/error?errorNo=403");
						return;
					}
				}			
			}	
		}
		chain.doFilter(request, response);
	}

}
