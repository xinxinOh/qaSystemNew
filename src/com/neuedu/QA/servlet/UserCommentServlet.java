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
import com.neuedu.QA.service.AnswerService;
import com.neuedu.QA.service.AskQuestionService;
import com.neuedu.QA.service.CollectionService;
import com.neuedu.QA.service.impl.AnswerServiceImpl;
import com.neuedu.QA.service.impl.AskQuestionServiceImpl;
import com.neuedu.QA.service.impl.CollectionServiceImpl;

/**
 * Servlet implementation class UserCommentServlet
 */
@WebServlet("/UserCommentServlet")
public class UserCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String user_id = request.getParameter("user_id");
		int start1 = Integer.parseInt(request.getParameter("start1"));
		int start2 = Integer.parseInt(request.getParameter("start2"));
		int start3 = Integer.parseInt(request.getParameter("start3"));
		
		//��������ش�
		AnswerService answerService = new AnswerServiceImpl();
		ArrayList<Answer> answers = answerService.showUserAnswer(user_id,start1,start1+10);
		request.getSession().setAttribute("answers", answers);
		
		//�ش�����ĸ���
		
		
		//�ش������
		AskQuestionService askQuestionService = new AskQuestionServiceImpl();
		ArrayList<Question> answerQuestions = new ArrayList<Question>();
		Iterator<Answer> answerIt = answers.iterator();
		while (answerIt.hasNext()) {
			Answer answer = answerIt.next();
			int q_id = answer.getQuestion_id();
			Question question = askQuestionService.selectQuestion(q_id);
			answerQuestions.add(question);
		}
		request.getSession().setAttribute("answerQuestions", answerQuestions);
		
		//�����ղ�����;
		CollectionService collectionService = new CollectionServiceImpl();
		ArrayList<Question> collectQuestions = collectionService.showCollection(user_id, start2, start2+10);
		request.getSession().setAttribute("collectQuestions", collectQuestions);
		
		//����������
		AskQuestionService questionService = new AskQuestionServiceImpl();
		ArrayList<Question> questions = questionService.ShowUserQuestion(user_id, start3, start3+10);
		request.getSession().setAttribute("questions", questions);
		
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
