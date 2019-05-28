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
public class ToPersonalCenterServlet extends  HttpServlet {
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
		System.out.println("ToPersonalCenterServlet");
		String user_id = ((UserInfo)request.getSession().getAttribute("user")).getUser_id();
		
		//设置问题回答
		String start1_s = request.getParameter("start1");
		int start1 = 0;
		if (start1_s != null && !start1_s.equals("")) {
			start1 = Integer.parseInt(request.getParameter("start1"));
		}
		AnswerService answerService = new AnswerServiceImpl();
		ArrayList<Answer> answers = answerService.showUserAnswer(user_id,start1*5, start1+5);
		request.getSession().setAttribute("answers", answers);
		
		//求得回答总数
		int answers_num = answerService.total("u_id", user_id);
		System.out.println(answers_num);
		request.getSession().setAttribute("answers_num", answers_num);
		//回答的问题
		AskQuestionService askQuestionService = new AskQuestionServiceImpl();
		ArrayList<Question> answerQuestions = new ArrayList<Question>();
		if (answers.size()!=0 && answers!=null) {
			Iterator<Answer> answerIt = answers.iterator();
			while (answerIt.hasNext()) {
				Answer answer = answerIt.next();
				int q_id = answer.getQuestion_id();
				Question question = askQuestionService.selectQuestion(q_id);
				//System.out.println("question   !!!"+question.getTitle());
				answerQuestions.add(question);
			}	
		}
		request.getSession().setAttribute("answerQuestions", answerQuestions);
		
		//设置收藏问题;
		String start2_s = request.getParameter("start2");
		int start2 = 0;
		if (start2_s != null && !start2_s.equals("")) {
			start2 = Integer.parseInt(request.getParameter("start2"));
		}
		CollectionService collectionService = new CollectionServiceImpl();
		ArrayList<Question> collectQuestions = collectionService.showCollection(user_id, start2*5, start2+5);
		request.getSession().setAttribute("collectQuestions", collectQuestions);
		//System.out.println("sherched "+collectQuestions.size());
		//System.out.println("questions");
		
		//设置收藏问题的个数
		int collects_num =  collectionService.total("u_id", user_id);
		System.out.println(collects_num);
		request.getSession().setAttribute("collects_num",collects_num);
		//设置提问题
		String start3_s = request.getParameter("start3");
		int start3 = 0;
		if (start3_s != null && !start3_s.equals("")) {
			start3 = Integer.parseInt(request.getParameter("start3"));
		}
		//System.out.println(start3);
		AskQuestionService questionService = new AskQuestionServiceImpl();
		ArrayList<Question> questions = questionService.ShowUserQuestion(user_id, start3*5, start3+5);
		request.getSession().setAttribute("questions", questions);
		
		//设置提出问题个数
		int questions_num =  questionService.total("u_id", user_id);
		System.out.println(questions_num);
		request.getSession().setAttribute("questions_num",questions_num);
		
		request.getRequestDispatcher("//user_home_page/userPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-gene rated method stub
		doGet(request, response);
	}

}
