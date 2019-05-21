package com.neuedu.QA.service.impl;


import java.util.ArrayList;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.dao.impl.QuestionDaoImpl;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.service.AnswerService;

public class AnswerServiceImpl implements AnswerService{
	
	public AnswerDaoImpl answerDaoImpl=new AnswerDaoImpl();
	public QuestionDaoImpl questionDaoImpl=new QuestionDaoImpl();
	@Override
	public int addAnswer(Answer answer, int question_id, int user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAnswer(int answer_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Answer> showUserAnswer(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
