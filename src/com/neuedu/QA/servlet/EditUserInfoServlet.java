package com.neuedu.QA.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.UserService;
import com.neuedu.QA.service.impl.UserServiceImpl;

/**
 * Servlet implementation class EditUserInfoServlet
 */
@WebServlet("/EditUserInfoServlet")
public class EditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserService userService = new UserServiceImpl();
		
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		String user_nikname = request.getParameter("user_nikname");
		String user_sex = request.getParameter("user_sex");
		String user_introduction = request.getParameter("user_introduction");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(request.getParameter("user_birthdate"));
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!user_nikname.equals("")&&user_nikname!=null) {
			user.setNickname(user_nikname);
		}
		if (!user_introduction.equals("")&&user_introduction!=null) {
			user.setIntroduction(user_introduction);
		}
		if (date != null) {
			user.setBirthdate(date);
		}
		if (!user_sex.equals("")&& user_sex!=null) {
			user.setSex(user_sex);
		}
		
		userService.modifyInfo(user);
		request.getSession().setAttribute("user", user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
