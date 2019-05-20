package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.Question;

public interface QuestionDao {
	
	public ResultSet SelectAllQuestion(Integer user_id);
	public ResultSet SelectPopularQuestion();
	public ResultSet SelectLoadQuestion(Integer type,int start ,int end);
	public ResultSet selectQuestion(Integer question_id);
	public Integer addQuestion(Question question);
	public Integer updateQuestion(Question question);
	public Integer deleteQuestion(Integer questiom_id);
}
