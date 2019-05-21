package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dao.impl.QuestionDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.service.AskQuestionService;

public class AskQuestionServiceImpl implements AskQuestionService {

	public QuestionDaoImpl questionDaoImpl = new QuestionDaoImpl();
	
	@Override
	public Integer askQuestion(Question question, String user_id) {
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
	public ArrayList<Question> ShowUserQuestion(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
