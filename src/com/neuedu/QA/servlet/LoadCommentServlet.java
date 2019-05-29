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
import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.service.impl.LoadCommentServiceImpl;

/**
 * Servlet implementation class LoadCommentServlet
 */
@WebServlet("/LoadCommentServlet")
public class LoadCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoadCommentServiceImpl loadCommentServiceImpl = new LoadCommentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCommentServlet() {
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
		if(request.getParameter("type").equals("comment")){
            String answer_id = request.getParameter("answer_id");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            ArrayList<Comment> Comment_list = loadCommentServiceImpl.LoadComment(Integer.parseInt(answer_id), Integer.parseInt(start), Integer.parseInt(end));
            
            String jsonString_Comment = JSON.toJSONString(Comment_list);
            
            out.write(jsonString_Comment);
//            System.out.println(3);
//            System.out.println(jsonString_Comment);
        }
        
        if(request.getParameter("type").equals("second_comment")){
        	
            String comment_id = request.getParameter("comment_id");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            ArrayList<Comment> second_comment_list = loadCommentServiceImpl.LoadSecondComment(Integer.parseInt(comment_id), Integer.parseInt(start), Integer.parseInt(end));
            String jsonString_second_comment = JSON.toJSONString(second_comment_list);
            
            out.write(jsonString_second_comment);
//            System.out.println(4);
//            System.out.println(jsonString_second_comment);
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
