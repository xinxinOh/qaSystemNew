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
		
		//璇锋眰缂栫爜
        request.setCharacterEncoding("UTF-8");
        //鍝嶅簲绫诲瀷
        response.setContentType("text/html");
        //鍝嶅簲缂栫爜
        response.setCharacterEncoding("UTF-8"); 
		
		//鑾峰彇杈撳叆鐨勭敤鎴峰悕鍜屽瘑鐮�
		String p1 = request.getParameter("username");
		String p2 = request.getParameter("password");
	    
		//涓庢暟鎹簱浜や簰鐨勬柟娉�
		impl.Login(p1, p2);
		//String selectedUser = impl.Login(p1, p2);
		//System.out.println(selectedUser);
		System.out.println("娆㈣繋鐢ㄦ埛锛�--"+p1+"--鐧诲綍鎴愬姛");
        String i = impl.Login(p1, p2);
        if (i != null ) {
        	UserInfo user = impl.selectUser(p1);
        	request.getSession().setAttribute("user", user);
			//response.getWriter().println("鐢ㄦ埛鐧诲綍鎴愬姛");
			System.out.println("鐧诲綍鎴愬姛");
			request.getRequestDispatcher("//MainPage.jsp").forward(request, response);
		}else {
                System.out.println("鐧诲綍澶辫触");
				request.getRequestDispatcher("//default.jsp").forward(request, response);
				//response.sendRedirect("default.jsp");

			    }
        //鑾峰彇MD5鍔犲瘑瀵硅薄
//        MD5 pwd = new MD5();
//
//        try {
//            p2 = pwd.getMD5(request.getParameter("password"));
//        } catch (Exception e) {
//            // TODO: handle exceptio
//            e.printStackTrace();
//        }        
//        //鍒濆鍖杁ao灞�
//        BaseDao userDao = new BaseDao();
//        /**璋冪敤dao灞傜殑鑾峰彇鐢ㄦ埛鐨勬柟娉�*/
//        try {
//            String user = BaseDao.executeSelect(p1 , p2);
//            System.out.println(user);
//            
//            //鑾峰彇session,灏嗚幏鍙栧埌鐨勬暟鎹繚瀛樺埌session涓�
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            //閲嶅畾鍚戯紝璺宠浆鍒版垚鍔熼〉闈�
//            response.sendRedirect("涓婚〉.jsp");
//            
//        } catch (Exception e) {      
        //            e.printStackTrace();
//        }        
		
		
		
		}

	
	
	}


