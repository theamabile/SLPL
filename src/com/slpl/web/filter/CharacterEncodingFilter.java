package com.slpl.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = {"/*"},
			initParams = {@WebInitParam(name="encoding",value="UTF-8")}
)
public class CharacterEncodingFilter implements Filter {
	
	private String encoding  ="UTF-8";
	//web.xml에 filter-mapping써준거랑 연관이 있다
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
		System.out.println("before필터실행");
		chain.doFilter(request, response);
		System.out.println("after 필터실행");
	}
	
	//web.xml에 init-parameter써준거랑 연관이 있다
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	} 

}
