package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Question;

public interface AskQuestionService {
	
	public Integer askQuestion(Question question , String user_id);
	public int deleteQuestion(int question_id);
	public int updateQuestion(Question question);
	ArrayList<Question> ShowUserQuestion(String user_id, int start, int end);
	public Question selectQuestion(int question_id);
	public int total(String param, Object value);

}
