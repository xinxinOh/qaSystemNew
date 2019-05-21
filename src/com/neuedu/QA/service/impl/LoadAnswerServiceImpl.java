package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.service.LoadAnswerService;

public class LoadAnswerServiceImpl implements LoadAnswerService{

	public AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
	
	@Override
	public ArrayList<Question> LoadPopularQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Question> LoadCategoryQuestion(int type, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Question> LoadUserCenterQuestion(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
