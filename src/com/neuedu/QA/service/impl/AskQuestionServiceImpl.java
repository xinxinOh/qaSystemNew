package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.Question;

public class AskQuestionServiceImpl extends BaseDao implements com.neuedu.QA.service.AskQuestionService {

	@Override
	public Integer askQuestion(Question question, int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteQuestion(int question_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Question> ShowUserQuestion(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
