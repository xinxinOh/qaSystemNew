package com.neuedu.QA.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		LoadQuestionServiceImpl loadQuestionServiceImpl=new LoadQuestionServiceImpl();
		ArrayList<Question> questions=loadQuestionServiceImpl.LoadPopularQuestion();
		request.getSession().setAttribute("questions", questions);
		System.out.println("load popular sucess");
		/*
		 * System.out.println("323"); System.out.println(questions.toString());
		 */
		request.getRequestDispatcher("MainPage.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
