package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

		//璇锋眰缂栫爜
        request.setCharacterEncoding("UTF-8");
        //鍝嶅簲绫诲瀷
        response.setContentType("text/html");
        //鍝嶅簲缂栫爜
        response.setCharacterEncoding("UTF-8"); 
		//鑾峰彇瀛樺叆session鐨勭爜
		//String code=(String)request.getSession().getAttribute("p3");
		//鑾峰彇涔嬪悗鍒犻櫎锛岄槻姝笅娆￠獙璇侀敊璇�
		request.getSession().removeAttribute("p3");

		if ( (p3 !=null) && (p4.equals(p3))) {
			UserInfo temp = new UserInfo(p1, p2, p1, new Date(), "男", 0, null);
			String i = impl.Register(temp);
			System.out.println(i);
			if (i != null) {
				System.out.println("娉ㄥ唽鎴愬姛");
				request.getSession().setAttribute("user", temp);
				request.getRequestDispatcher("//MainPage.jsp").forward(request, response);
				}
				else {
	                System.out.println("娉ㄥ唽澶辫触");
					request.getRequestDispatcher("//default.jsp").forward(request, response);
					//response.sendRedirect("default.jsp");
				    }				
		}else {
			//response.getWriter().println("鐢ㄦ埛鐧诲綍鎴愬姛");		
			System.out.println("楠岃瘉鐮佽緭鍏ラ敊璇�");
			request.getRequestDispatcher("//default.jsp").forward(request, response);
			//response.sendRedirect("default.jsp");
			}	

			    
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		
	}

}
