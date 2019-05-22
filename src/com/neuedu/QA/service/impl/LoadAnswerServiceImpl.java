package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.service.LoadAnswerService;
import com.sun.prism.paint.RadialGradient;

public class LoadAnswerServiceImpl implements LoadAnswerService{

	public AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
	
	@Override
	public ArrayList<Answer> LoadAnswer(int question_id,int start,int end) {
		
		ResultSet rs = answerDaoImpl.SelectAnswer(question_id, start, end);
		ArrayList<Answer> answer_list = new ArrayList<Answer>();
		try {
			while(rs.next()) {
				Answer answer = new Answer();
				answer.setAnswer_id(rs.getInt(1));
				answer.setQuestion_id(rs.getInt(2));
				answer.setUser_id(rs.getString(3));
				answer.setContent(rs.getString(4));
				answer.setUpvote_num(rs.getInt(5));
				answer.setDownvote_num(rs.getInt(6));
				answer.setComment_num(rs.getInt(7));
				answer.setAnswer_date(rs.getDate(8));
				answer_list.add(answer);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer_list;
	}

	@Override
	public ArrayList<Answer> LoadUserCenterAnswer(String user_id, int start, int end) {
		ResultSet rs = answerDaoImpl.SelectAllAnswer(user_id, start, end);
		ArrayList<Answer> answer_list = new ArrayList<Answer>();
		try {
			while(rs.next()) {
				Answer answer = new Answer();
				answer.setAnswer_id(rs.getInt(1));
				answer.setQuestion_id(rs.getInt(2));
				answer.setUser_id(rs.getString(3));
				answer.setContent(rs.getString(4));
				answer.setUpvote_num(rs.getInt(5));
				answer.setDownvote_num(rs.getInt(6));
				answer.setComment_num(rs.getInt(7));
				answer.setAnswer_date(rs.getDate(8));
				answer_list.add(answer);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer_list;
	}
}
