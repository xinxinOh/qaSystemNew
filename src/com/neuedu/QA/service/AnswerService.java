package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Answer;

public interface AnswerService {
	public int addAnswer(Answer answer,int question_id,int user_id);
	public int deleteAnswer(int answer_id);
	public int updateAnswer(Answer answer);
	public ArrayList<Answer> showUserAnswer(int user_id);
}
