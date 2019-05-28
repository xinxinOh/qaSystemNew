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
import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.LoadAnswerServiceImpl;
import com.neuedu.QA.service.impl.LoadCommentServiceImpl;

/**
 * Servlet implementation class LoadAnswerServlet
 */
@WebServlet("/LoadAnswerServlet")
public class LoadAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoadAnswerServiceImpl loadAnswerServiceImpl = new LoadAnswerServiceImpl();
    UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
    LoadCommentServiceImpl loadCommentServiceImpl = new LoadCommentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAnswerServlet() {
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
        
        if(request.getParameter("type").equals("answer")){
        String question_id = request.getParameter("question_id");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        System.out.println("get"+question_id+start+end);
        ArrayList<Answer> answer_list = loadAnswerServiceImpl.LoadAnswer(Integer.parseInt(question_id), Integer.parseInt(start), Integer.parseInt(end));
        ArrayList<UserInfo> UserInfo_list = new ArrayList<UserInfo>();
        for(int i = 0 ; i < answer_list.size() ; i++) {
        	UserInfo_list.add(userInfoDaoImpl.SelectUser(answer_list.get(i).getUser_id()));
        }
        String jsonString_answer = JSON.toJSONString(answer_list);
        
        out.write(jsonString_answer);
//        System.out.println(1);
//        System.out.println(jsonString_answer);
        }
        
        
        
        
        if(request.getParameter("type").equals("user")){
        	
            String user_id = request.getParameter("user_id");
            
            UserInfo userInfo = userInfoDaoImpl.SelectUser(user_id);
            
            String jsonString_UserInfo = JSON.toJSONString(userInfo);
            
            out.write(jsonString_UserInfo);
            System.out.println(2);
            System.out.println(jsonString_UserInfo);
        }
        
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
		
        
	}

}
