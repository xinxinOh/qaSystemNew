package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.QuestionDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.Question;

public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	@Override
	public ResultSet SelectAllQuestion(Integer user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet SelectPopularQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet SelectLoadQuestion(Integer type, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectQuestion(Integer question_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteQuestion(Integer questiom_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
