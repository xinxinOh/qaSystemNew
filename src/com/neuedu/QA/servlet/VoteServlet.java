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
import com.neuedu.QA.entity.UserVote;
import com.neuedu.QA.service.impl.VoteServiceImpl;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VoteServiceImpl voteServiceImpl = new VoteServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
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
        
        if(request.getParameter("votetype").equals("all"))	{
            String user_id = request.getParameter("user_id");
            String type = request.getParameter("type");
            String category = request.getParameter("category");
            ArrayList<UserVote> UserVote_list = voteServiceImpl.getAllVote(user_id , Integer.parseInt(type), Integer.parseInt(category));
            String jsonString_UserVote = JSON.toJSONString(UserVote_list);
            
            out.write(jsonString_UserVote);
            System.out.println(jsonString_UserVote);
            return;
//        System.out.println(1);
//        System.out.println(jsonString_answer);
        }
        
        if(request.getParameter("type").equals("0") || request.getParameter("type").equals("1"))	{
        String user_id = request.getParameter("user_id");
        String to_id = request.getParameter("to_id");
        String type = request.getParameter("type");
        String category = request.getParameter("category");
        int ret = voteServiceImpl.SelectVote(user_id, Integer.parseInt(to_id), Integer.parseInt(type), Integer.parseInt(category));
        
        if(ret==0) {
        	out.write("0");
        }
        
        if(ret==1) {
        	ret = voteServiceImpl.userVote(user_id, Integer.parseInt(to_id), Integer.parseInt(type), Integer.parseInt(category));
        	out.write("1");
        }
        
        }
        
        
        
        if(request.getParameter("type").equals("2") || request.getParameter("type").equals("3"))	{
        String user_id = request.getParameter("user_id");
        String to_id = request.getParameter("to_id");
        String type = request.getParameter("type");
        String category = request.getParameter("category");
        
        
        
        int ret = voteServiceImpl.userVote(user_id, Integer.parseInt(to_id), Integer.parseInt(type), Integer.parseInt(category));
        System.out.println("sdadasdsadad"+ret);
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
