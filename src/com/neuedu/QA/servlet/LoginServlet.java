package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.UserServiceImpl;

import sun.security.provider.MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	UserServiceImpl impl=new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//请求编码
        request.setCharacterEncoding("UTF-8");
        //响应类型
        response.setContentType("text/html");
        //响应编码
        response.setCharacterEncoding("UTF-8"); 
		
		//获取输入的用户名和密码
		String p1 = request.getParameter("username");
		String p2 = request.getParameter("password");
	    
		//与数据库交互的方法
		impl.Login(p1, p2);
		//String selectedUser = impl.Login(p1, p2);
		//System.out.println(selectedUser);
		System.out.println("欢迎用户：--"+p1+"--登录成功");
        String i = impl.Login(p1, p2);
        if (i != null ) {
			//response.getWriter().println("用户登录成功");
			System.out.println("登录成功");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
                System.out.println("登录失败");
				request.getRequestDispatcher("/default.jsp").forward(request, response);
				//response.sendRedirect("default.jsp");

			    }
        //获取MD5加密对象
//        MD5 pwd = new MD5();
//
//        try {
//            p2 = pwd.getMD5(request.getParameter("password"));
//        } catch (Exception e) {
//            // TODO: handle exceptio
//            e.printStackTrace();
//        }        
//        //初始化dao层
//        BaseDao userDao = new BaseDao();
//        /**调用dao层的获取用户的方法*/
//        try {
//            String user = BaseDao.executeSelect(p1 , p2);
//            System.out.println(user);
//            
//            //获取session,将获取到的数据保存到session中
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            //重定向，跳转到成功页面
//            response.sendRedirect("主页.jsp");
//            
//        } catch (Exception e) {      
        //            e.printStackTrace();
//        }        
		
		
		
		}

	
	
	}


