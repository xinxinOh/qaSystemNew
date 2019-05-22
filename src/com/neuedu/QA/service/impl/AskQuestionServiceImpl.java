package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.neuedu.QA.dao.impl.QuestionDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.service.AskQuestionService;

public class AskQuestionServiceImpl implements AskQuestionService {

	public QuestionDaoImpl questionDaoImpl = new QuestionDaoImpl();
	
	@Override
	public Integer askQuestion(Question question, String user_id) {
		// TODO Auto-generated method stub
		question.setUser_id(user_id);
		return questionDaoImpl.addQuestion(question);
	}

	@Override
	public int deleteQuestion(int question_id) {
		// TODO Auto-generated method stub
		return questionDaoImpl.deleteQuestion(question_id);
	}

	@Override
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDaoImpl.updateQuestion(question);
	}

	@Override
	public ArrayList<Question> ShowUserQuestion(String user_id) {
		// TODO Auto-generated method stub
		ResultSet resultSet = questionDaoImpl.SelectAllQuestion(user_id);
		
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			while (resultSet.next()) {
				Question question = new Question();
				question.setQuestion_id(resultSet.getInt(1));
				question.setUser_id(resultSet.getString(2));
				question.setTitle(resultSet.getString(3));
				question.setContent(resultSet.getString(4));
				question.setFever(resultSet.getInt(5));
				question.setAnswer_num(resultSet.getInt(6));
				question.setCollect_num(resultSet.getInt(7));
				question.setQuestion_date(resultSet.getDate(8));
				question.setType(resultSet.getInt(9));
				questions.add(question);
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}
	
	/*测试*/
	/*
	public static void main(String[] args) {
		AskQuestionService askQuestionService = new AskQuestionServiceImpl();
		//提出问题
		/*
		Question question = new Question( "ahahaha", "try", "have a try", new Date(), 2);
		askQuestionService.askQuestion(question, "ahahaha");
		*/
		//删除问题
		//askQuestionService.deleteQuestion(4);
		//显示问题
		/*
		ArrayList<Question> questions = askQuestionService.ShowUserQuestion("sssss1");
		for (Question question : questions) {
			System.out.println(question.getQuestion_id()+"    "+question.getTitle() +"    "+question.getUser_id());
		}
	}*/

}
