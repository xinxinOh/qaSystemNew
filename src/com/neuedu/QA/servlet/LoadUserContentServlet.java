package com.neuedu.QA.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.AnswerService;
import com.neuedu.QA.service.AskQuestionService;
import com.neuedu.QA.service.CollectionService;
import com.neuedu.QA.service.impl.AnswerServiceImpl;
import com.neuedu.QA.service.impl.AskQuestionServiceImpl;
import com.neuedu.QA.service.impl.CollectionServiceImpl;

/**
 * Servlet implementation class LoadUserContentServlet
 */
@WebServlet("/LoadUserContentServlet")
public class LoadUserContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUserContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ToPersonalCenterServlet");
		String user_id = ((UserInfo)request.getSession().getAttribute("user")).getUser_id();
		
		//��������ش�
		String start1_s = request.getParameter("start1");
		int start1 = 0;
		if (start1_s != null) {
			start1 = Integer.parseInt(request.getParameter("start1"));
		}
		
		AnswerService answerService = new AnswerServiceImpl();
		ArrayList<Answer> answers = answerService.showUserAnswer(user_id,start1*5, start1+5);
		request.getSession().setAttribute("answers", answers);
		//��ûش�����
		
		//�ش������
		AskQuestionService askQuestionService = new AskQuestionServiceImpl();
		ArrayList<Question> answerQuestions = new ArrayList<Question>();
		if (answers.size()!=0) {
			Iterator<Answer> answerIt = answers.iterator();
			while (answerIt.hasNext()) {
				Answer answer = answerIt.next();
				int q_id = answer.getQuestion_id();
				Question question = askQuestionService.selectQuestion(q_id);
				System.out.println("question   !!!"+question.getTitle());
				answerQuestions.add(question);
			}	
		}
		request.getSession().setAttribute("answerQuestions", answerQuestions);
		
		//�����ղ�����;
		String start2_s = request.getParameter("start2");
		int start2 = 0;
		if (start2_s != null) {
			start2 = Integer.parseInt(request.getParameter("start2"));
		}
		CollectionService collectionService = new CollectionServiceImpl();
		ArrayList<Question> collectQuestions = collectionService.showCollection(user_id, start2*5, start2+5);
		request.getSession().setAttribute("collectQuestions", collectQuestions);
		
		System.out.println("sherched "+collectQuestions.size());
		
		//����������
		String start3_s = request.getParameter("start3");
		int start3 = 0;
		if (start3_s != null) {
			start3 = Integer.parseInt(request.getParameter("start3"));
		}
		AskQuestionService questionService = new AskQuestionServiceImpl();
		ArrayList<Question> questions = questionService.ShowUserQuestion(user_id, start3*5, start3+5);
		request.getSession().setAttribute("questions", questions);
		System.out.println("sherched "+questions.size());
		request.getRequestDispatcher("//user_home_page/userPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}