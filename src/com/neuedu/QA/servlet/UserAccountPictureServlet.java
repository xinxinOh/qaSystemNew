package com.neuedu.QA.servlet;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.entity.UserInfo;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * Servlet implementation class userAccountPageServlet
 */

@WebServlet("/UserAccountPictureServlet")
public class UserAccountPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAccountPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getContextPath()+"/Resource/UserAccountPicture";
		System.out.println(path);
		
		//结果json对象
		//上传文件名
		UserInfo user = (UserInfo)request.getSession().getAttribute("user");
		String name = path+"/"+user.getUser_id()+"。jpg";
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
