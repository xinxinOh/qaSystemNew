package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dao.impl.QuestionDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.service.AskQuestionService;

public class AskQuestionServiceImpl implements AskQuestionService {

	private QuestionDaoImpl questionDao;
	public AskQuestionServiceImpl() {
		// TODO Auto-generated constructor stub
		questionDao = new QuestionDaoImpl();
	}
	
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
