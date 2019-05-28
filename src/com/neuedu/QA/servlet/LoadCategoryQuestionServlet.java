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
import com.neuedu.QA.service.impl.LoadQuestionServiceImpl;



/**
 * Servlet implementation class LoadCatogoryQuestion
 */
@WebServlet("/LoadCategoryQuestionServlet")
public class LoadCategoryQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadCategoryQuestionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(111);
		response.setContentType("application/text; charset=utf-8");
        //System.out.println(111);
        PrintWriter out = response.getWriter();

	  LoadQuestionServiceImpl loadQuestionServiceImpl=new LoadQuestionServiceImpl(); 
	  String a=request.getParameter("category"); 
	  String start=request.getParameter("start"); 
	  String end=request.getParameter("end"); 
	
	  System.out.println("category:"+a+"   start:"+start+"   end:"+end);

	 
		  ArrayList<Question> questions=loadQuestionServiceImpl.LoadCategoryQuestion(Integer.parseInt(a),Integer.parseInt(start),Integer.parseInt(end)); 
		  String jsonString = JSON.toJSONString(questions);
		  //request.getSession().setAttribute("questions", jsonString);
		  out.write(jsonString);
		  System.out.println(jsonString);
	 

	  //request.getRequestDispatcher("MainPage.jsp").forward(request, response);
	  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		 
	}

}
