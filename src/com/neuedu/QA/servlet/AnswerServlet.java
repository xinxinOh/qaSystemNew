package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.AnswerServiceImpl;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AnswerServiceImpl answerServiceImpl = new AnswerServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();
        UserInfo user=(UserInfo)request.getSession().getAttribute("user");
        
        if (user==null){ 
			out.write("2");
			System.out.println("ʧ�� ���ȵ�¼");
			return;
		}

        String question_id = request.getParameter("question_id");
        String content = request.getParameter("content");
        int ret = answerServiceImpl.addAnswer(new Answer(0,Integer.parseInt(question_id),user.getUser_id(),content,0,0,0,new Date()));
        
        if(ret==0) {
        	out.write("0");
        }
        
        if(ret==1) {
        	out.write("1");
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
