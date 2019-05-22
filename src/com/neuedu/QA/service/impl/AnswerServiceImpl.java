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
	public ArrayList<Answer> showUserAnswer(String user_id) {
		ResultSet rs=answerDaoImpl.SelectAllAnswer(user_id);
		ArrayList<Answer> answers=new ArrayList<Answer>();
	    try {
			for(;rs.next();) {
				Answer answer=new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getDate(8));                       
			    answers.add(answer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 return answers;
	}

}
