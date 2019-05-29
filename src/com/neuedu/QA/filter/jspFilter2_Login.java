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
 *��¼������
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
		//��ȡurl
		String url = ((HttpServletRequest)request).getRequestURI();
		System.out.println("login Fileter start");
		//��Ϊ��������ҳ�������
		if (!url.contains("user_home_page")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//�ѵ�¼�����
		if (((HttpServletRequest)request).getSession().getAttribute("user")!= null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//������ת����¼ҳ��
		request.setAttribute("erroMessage", "please login first!");
		request.getRequestDispatcher("//login.jsp").forward(request, response);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
