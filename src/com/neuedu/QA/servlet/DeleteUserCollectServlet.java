package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.CollectionServiceImpl;

/**
 * Servlet implementation class DeleteUserCollectServlet
 */
@WebServlet("/DeleteUserCollectServlet")
public class DeleteUserCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserCollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();
        //UserInfo user=(UserInfo)request.getSession().getAttribute("user");
		/*
		 * if (user==null) { request.setAttribute("message", "ÇëÏÈµÇÂ¼£¡");
		 * request.getRequestDispatcher("//MainPage.jsp").forward(request, response); }
		 * else {
		 */
        //String user_id = user.getUser_id();
        String user_id ="test";
        String q_id=request.getParameter("questionID"); 
  	    System.out.println("delete collect servlet question_id:"+q_id);
  	    CollectionServiceImpl collectionServiceImpl=new CollectionServiceImpl();
  	    
  	    int i=collectionServiceImpl.deleteCollection(user_id, Integer.parseInt(q_id));
        String string=String.valueOf(i);
		  //request.getSession().setAttribute("questions", jsonString);
		out.write(string);
		System.out.println("delete collection servlet run lines:"+string);
       // }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
