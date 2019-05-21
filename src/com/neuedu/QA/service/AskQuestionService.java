package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Question;

public interface AskQuestionService {
	
	public Integer askQuestion(Question question , String user_id);
	public int deleteQuestion(int question_id);
	public int updateQuestion(Question question);
	public ArrayList<Question> ShowUserQuestion(String user_id);

}
