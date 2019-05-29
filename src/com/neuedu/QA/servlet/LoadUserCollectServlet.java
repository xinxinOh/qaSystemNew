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
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.impl.CollectionServiceImpl;

/**
 * Servlet implementation class LoadUserCollectServlet
 */
@WebServlet("/LoadUserCollectServlet")
public class LoadUserCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUserCollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/text; charset=utf-8");
        PrintWriter out = response.getWriter();
       // UserInfo user=(UserInfo)request.getSession().getAttribute("user");
      //  String user_id = user.getUser_id();
        String user_id ="test";
  	    CollectionServiceImpl collectionServiceImpl=new CollectionServiceImpl();
  	    
        ArrayList<Question> questions=collectionServiceImpl.showCollection(user_id, 0, 100);
        String jsonString_collectQuestion = JSON.toJSONString(questions);
        System.out.println("LoadUserCollectServlet");
        System.out.println(jsonString_collectQuestion);
        out.write(jsonString_collectQuestion);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
