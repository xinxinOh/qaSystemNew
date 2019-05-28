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
import com.neuedu.QA.service.LoadQuestionService;
import com.neuedu.QA.service.impl.LoadQuestionServiceImpl;


/**
 * Servlet implementation class LoadQuestionServlet
 */
@WebServlet("/LoadQuestionServlet")
public class LoadQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoadQuestionServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        
        String start=request.getParameter("start"); 
  	  String end=request.getParameter("end"); 
  	
  	  System.out.println("   start:"+start+"   end:"+end);
		LoadQuestionServiceImpl loadQuestionServiceImpl=new LoadQuestionServiceImpl();
		ArrayList<Question> questions=loadQuestionServiceImpl.LoadPopularQuestion(Integer.parseInt(start),Integer.parseInt(end));
		String jsonString = JSON.toJSONString(questions);
		  //request.getSession().setAttribute("questions", jsonString);
		out.write(jsonString);
		System.out.println(jsonString);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
