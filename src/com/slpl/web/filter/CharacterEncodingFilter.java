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

@WebFilter(
		urlPatterns = {"/*"},
		initParams = {@WebInitParam(name="encoding", value="UTF-8")}
		)
public class CharacterEncodingFilter implements Filter {
	
	private String encoding = "UTF-8";		// 사용자가 사용할 때 설정 할 수 있게 하려고

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
		// web.xml에 filter쪽에 init-param이 있으면 그걸 갖고와서 셋팅함
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

}
