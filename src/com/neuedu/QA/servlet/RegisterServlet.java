package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   UserServiceImpl impl = new UserServiceImpl();
    public RegisterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p1 = request.getParameter("username");
		String p2 = request.getParameter("password");
		String p3 = request.getParameter("code");
		String p4 = request.getParameter("yzmH");

		//请求编码
        request.setCharacterEncoding("UTF-8");
        //响应类型
        response.setContentType("text/html");
        //响应编码
        response.setCharacterEncoding("UTF-8"); 
		//获取存入session的码
		//String code=(String)request.getSession().getAttribute("p3");
		//获取之后删除，防止下次验证错误
		request.getSession().removeAttribute("p3");

		if ( (p3 !=null) && (p4.equals(p3))) {
			UserInfo temp = new UserInfo(p1, p2, p1, null, null, 0, null);
			String i = impl.Register(temp);
			System.out.println(i);
			if (i != null) {
				System.out.println("注册成功");
				request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				else {
	                System.out.println("注册失败");
					request.getRequestDispatcher("/default.jsp").forward(request, response);
					//response.sendRedirect("default.jsp");
				    }				
		}else {
			//response.getWriter().println("用户登录成功");		
			System.out.println("验证码输入错误");
			request.getRequestDispatcher("/default.jsp").forward(request, response);
			//response.sendRedirect("default.jsp");
			}	

			    
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		
	}

}
