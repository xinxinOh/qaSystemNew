package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.AnswerDao;
import com.neuedu.QA.entity.Answer;

public class AnswerDaoImpl implements AnswerDao{

	@Override
	public ResultSet SelectAllAnswer(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet SelectAnswer(int question_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Answer SelectOneAnswer(int answer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAnswer(Answer a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAnswer(Answer a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAnswer(int Answer_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
