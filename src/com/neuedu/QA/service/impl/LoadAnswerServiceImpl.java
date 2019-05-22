package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.service.LoadAnswerService;

public class LoadAnswerServiceImpl implements LoadAnswerService{

	public AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
	
	

	@Override
	public ArrayList<Answer> LoadAnswer(int question_id,int start,int end) {
		
		ResultSet rs = answerDaoImpl.SelectAnswer(question_id, start, end);
		ArrayList<Answer> answer_list = new ArrayList<Answer>();
		try {
			while (rs.next()) {
				answer_list.add(new Answer(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDate(8)));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer_list;
	}

	@Override
	public ArrayList<Answer> LoadUserCenterAnswer(String user_id) {
		
		ResultSet rs = answerDaoImpl.SelectAllAnswer(user_id);
		ArrayList<Answer> answer_list = new ArrayList<Answer>();
		try {
			while (rs.next()) {
				answer_list.add(new Answer(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDate(8)));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer_list;
	}

}
