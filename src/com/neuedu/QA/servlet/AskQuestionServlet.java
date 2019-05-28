package com.neuedu.QA.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.entity.Question;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.AskQuestionServiceImpl;

/**
 * Servlet implementation class AskQuestionServlet
 */
@WebServlet("/AskQuestionServlet")
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo user=(UserInfo)request.getSession().getAttribute("user");
		String user_id = user.getUser_id();
		String title = request.getParameter("title");  
		String category = request.getParameter("category");  
		String dsec = request.getParameter("desc");  

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date date=new Date();
		String dateStr = sdf.format(date);
		Date mydate=null;
		try {
			mydate = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(user_id+" "+title+"  "+category+" "+dsec);
		
		AskQuestionServiceImpl askQuestionServiceImpl=new AskQuestionServiceImpl();
		askQuestionServiceImpl.askQuestion(new Question(user_id, title, dsec, mydate, Integer.parseInt(category)), user_id);
		
		request.setAttribute("message", "发布成功！");
		request.getRequestDispatcher("//MainPage.jsp").forward(request, response);
	}

}
