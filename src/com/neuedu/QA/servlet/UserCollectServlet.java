package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.CollectionServiceImpl;
import com.neuedu.QA.service.impl.LoadQuestionServiceImpl;

/**
 * Servlet implementation class UserCollectServlet
 */
@WebServlet("/UserCollectServlet")
public class UserCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Í¬²½£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
		response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();
        UserInfo user=(UserInfo)request.getSession().getAttribute("user");
		//System.out.println("!!!!!!!"+"!!!!!"+user.getUser_id());
		 if (user==null){ 
			 out.write("2");
			System.out.println("ÊÕ²ØÊ§°Ü ÇëÏÈµÇÂ¼");
		 }
		 else {
		 
        String user_id = user.getUser_id();
        //String user_id ="test";
        String q_id=request.getParameter("questionID"); 
  	    System.out.println("collect servlet question_id:"+q_id);
  	    CollectionServiceImpl collectionServiceImpl=new CollectionServiceImpl();
  	    
  	    int i=collectionServiceImpl.addCollection(user_id, Integer.parseInt(q_id));
        String string=String.valueOf(i);
		  //request.getSession().setAttribute("questions", jsonString);
		out.write(string);
		System.out.println("collection servlet run lines:"+string);
        }
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
