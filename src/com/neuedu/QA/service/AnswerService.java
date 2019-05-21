package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Answer;

public interface AnswerService {
	public int addAnswer(Answer answer,int question_id,String user_id);
	public int deleteAnswer(int answer_id);
	public int updateAnswer(Answer answer);
	public ArrayList<Answer> showUserAnswer(String user_id);
}
