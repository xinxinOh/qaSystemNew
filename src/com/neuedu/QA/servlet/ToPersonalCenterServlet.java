package com.neuedu.QA.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.AnswerService;
import com.neuedu.QA.service.AskQuestionService;
import com.neuedu.QA.service.CollectionService;
import com.neuedu.QA.service.LoadQuestionService;
import com.neuedu.QA.service.impl.AnswerServiceImpl;
import com.neuedu.QA.service.impl.AskQuestionServiceImpl;
import com.neuedu.QA.service.impl.CollectionServiceImpl;
import com.neuedu.QA.service.impl.LoadQuestionServiceImpl;

/**
 * Servlet implementation class ToPersonalCenterServlet
 */
@WebServlet("/ToPersonalCenterServlet")
public class ToPersonalCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToPersonalCenterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("ToPersonalCenterServlet");
		String user_id = ((UserInfo)request.getSession().getAttribute("user")).getUser_id();
		
		//设置问题回答
		AnswerService answerService = new AnswerServiceImpl();
		ArrayList<Answer> answers = answerService.showUserAnswer(user_id,0,10);
		request.getSession().setAttribute("answers", answers);
		
		//回答的问题
		AskQuestionService askQuestionService = new AskQuestionServiceImpl();
		ArrayList<Question> answerQuestions = new ArrayList<Question>();
		if (answers.size()==0) {
			Iterator<Answer> answerIt = answers.iterator();
			while (answerIt.hasNext()) {
				Answer answer = answerIt.next();
				int q_id = answer.getQuestion_id();
				Question question = askQuestionService.selectQuestion(q_id);
				answerQuestions.add(question);
			}	
		}
		request.getSession().setAttribute("answerQuestions", answerQuestions);
		
		//设置收藏问题;
		CollectionService collectionService = new CollectionServiceImpl();
		ArrayList<Question> collectQuestions = collectionService.showCollection(user_id, 0, 10);
		request.getSession().setAttribute("collectQuestions", collectQuestions);
		
		System.out.println("sherched "+collectQuestions.size());
		
		//设置提问题
		AskQuestionService questionService = new AskQuestionServiceImpl();
		ArrayList<Question> questions = questionService.ShowUserQuestion(user_id, 0, 10);
		request.getSession().setAttribute("questions", questions);
		System.out.println("sherched "+questions.size());
		request.getRequestDispatcher("//user_home_page/userHeader.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
