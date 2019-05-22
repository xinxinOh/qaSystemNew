package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.Question;

public interface QuestionDao {
	
	ResultSet SelectAllQuestion(String user_id,int start ,int end);
	ResultSet SelectPopularQuestion();
	ResultSet SelectLoadQuestion(Integer type,int start ,int end);
	Question selectQuestion(Integer question_id);
	Integer addQuestion(Question question);
	Integer updateQuestion(Question question);
	Integer deleteQuestion(Integer questiom_id);
}
