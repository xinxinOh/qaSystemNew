package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {
	
	private AnswerDaoImpl answerDaoImpl;
	
	public AnswerServiceImpl() {
		// TODO Auto-generated constructor stub
		answerDaoImpl = new AnswerDaoImpl();
	}

	@Override
	public int addAnswer(Answer answer) {
		int i=answerDaoImpl.addAnswer(answer);
		return i;
	}

	@Override
	public int deleteAnswer(int answer_id) {
		int i=answerDaoImpl.deleteAnswer(answer_id);
		return i;
	}

	@Override
	public int updateAnswer(Answer answer) {
		int i=answerDaoImpl.updateAnswer(answer);
		return i;
	}

	@Override
	public ArrayList<Answer> showUserAnswer(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		ResultSet resultSet =answerDaoImpl.SelectAllAnswer(user_id, start, end);
		
		ArrayList<Answer> answers = new ArrayList<Answer>();
		try {
			while (resultSet.next()) {
				Answer answer = new Answer();
				answer.setQuestion_id(resultSet.getInt(2));
				answer.setUser_id(resultSet.getString(3));
				answer.setContent(resultSet.getString(4));
				answer.setUpvote_num(resultSet.getInt(5));
				answer.setDownvote_num(resultSet.getInt(6));
				answer.setComment_num(resultSet.getInt(7));
				answer.setAnswer_date(resultSet.getDate(8));
				answers.add(answer);
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	@Override
	public int totall(String param, Object value) {
		// TODO Auto-generated method stub
		return answerDaoImpl.total(param, value);
	}

}
