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
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.UserFollow;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.FollowServiceImpl;

/**
 * Servlet implementation class FollowUserServlet
 */
@WebServlet("/FollowUserServlet")
public class FollowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FollowServiceImpl followServiceImpl = new FollowServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowUserServlet() {
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
        String type = request.getParameter("type");
        System.out.println(type);
        if(type.equals("add")) {
        	System.out.println("gmiarng98rb298ng92rgn2");
        String user_id = request.getParameter("user_id");
        String to_user_id = request.getParameter("to_user_id");
        int ret = followServiceImpl.AddFollow(user_id, to_user_id);
        
        if(ret==0) {
        	out.write("0");
        }
        
        if(ret==1) {
        	out.write("1");
        }
        
        }
        System.out.println(type);
        if(type.equals("delete")) {
            String user_id = request.getParameter("user_id");
            String to_user_id = request.getParameter("to_user_id");
            int ret = followServiceImpl.DeleteFollow(user_id, to_user_id);
            
            if(ret==0) {
            	out.write("0");
            }
            
            if(ret==1) {
            	out.write("1");
            }
            
        }
        if(type.equals("allfollow")) {
        	String user_id = request.getParameter("user_id");
        	String start = request.getParameter("start");
        	String end = request.getParameter("end");
        	ArrayList<UserFollow> UserFollow_list = followServiceImpl.ShowFollow(user_id, Integer.parseInt(start), Integer.parseInt(end));

            String jsonString_UserFollow = JSON.toJSONString(UserFollow_list);
            
            out.write(jsonString_UserFollow);
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
