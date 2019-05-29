package com.neuedu.QA.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author 25001
 *登录拦截器
 */

@WebFilter(filterName = "/jspFilter2_Login", urlPatterns="*.jsp", dispatcherTypes= {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class jspFilter2_Login implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获取url
		String url = ((HttpServletRequest)request).getRequestURI();
		System.out.println("login Fileter start");
		//不为个人中心页面则放行
		if (!url.contains("user_home_page")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//已登录则放行
		if (((HttpServletRequest)request).getSession().getAttribute("user")!= null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//否则跳转到登录页面
		request.setAttribute("erroMessage", "please login first!");
		request.getRequestDispatcher("//login.jsp").forward(request, response);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
