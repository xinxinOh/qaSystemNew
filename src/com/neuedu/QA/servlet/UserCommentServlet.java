package com.neuedu.QA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.service.impl.UserCommentServiceImpl;

/**
 * Servlet implementation class UserCommentServlet
 */
@WebServlet("/UserCommentServlet")
public class UserCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCommentServiceImpl userCommentServiceImpl = new UserCommentServiceImpl();
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
		
		response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        if(request.getParameter("type").equals("answer_comment")){
        String answer_id = request.getParameter("answer_id");
        String content = request.getParameter("content");
        String user_id = request.getParameter("user_id");
        int ret = userCommentServiceImpl.AddComment(new Comment(0,Integer.parseInt(answer_id),user_id,content,new Date(),0,0));
        if(ret==0) {
        	out.write("0");
        }
        
        if(ret==1) {
        	out.write("1");
        }
        
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
