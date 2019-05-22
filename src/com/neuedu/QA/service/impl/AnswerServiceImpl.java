package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
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
	public int addAnswer(Answer answer, int question_id, String user_id) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		ResultSet rs=answerDaoImpl.SelectAllAnswer(user_id);
		ArrayList<Answer> answers=new ArrayList<Answer>();
		/*
		 * try { for(int i=0;rs.next();i++) { answers[i]=new Answer(answer_id,
		 * question_id, user_id, content, upvote_num, downvote_num, comment_num,
		 * answer_date); } return answers;
		 */
		 return null;
	}

}
