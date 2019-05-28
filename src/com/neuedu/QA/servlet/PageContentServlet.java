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
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.Question;

/**
 * Servlet implementation class PageContentServlet
 */
@WebServlet("/PageContentServlet")
public class PageContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see LoadUserContentServlet#LoadUserContentServlet()
     */
    public PageContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("//user_home_page/userPage.jsp").forward(request, response);
		String anSwers = JSON.toJSONString(((ArrayList<Answer>)(request.getSession().getAttribute("answers"))));
		String anSwerQuestions = JSON.toJSONString(((ArrayList<Question>)(request.getSession().getAttribute("answerQuestions"))));
		String colleCtQuestions = JSON.toJSONString(((ArrayList<Question>)(request.getSession().getAttribute("collectQuestions"))));
		String quEstions = JSON.toJSONString(((ArrayList<Question>)(request.getSession().getAttribute("questions"))));
		PrintWriter out = response.getWriter();
		out.write(anSwers);
		out.write(anSwerQuestions);
		out.write(colleCtQuestions);
		out.write(quEstions);
		System.out.println("success!");
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
