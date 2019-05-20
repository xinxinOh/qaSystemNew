package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.Question;

public interface QuestionDao {
	
	ResultSet SelectAllQuestion(Integer user_id);
	ResultSet SelectPopularQuestion();
	ResultSet SelectLoadQuestion(Integer type,int start ,int end);
	ResultSet selectQuestion(Integer question_id);
	Integer addQuestion(Question question);
	Integer updateQuestion(Question question);
	Integer deleteQuestion(Integer questiom_id);
}
