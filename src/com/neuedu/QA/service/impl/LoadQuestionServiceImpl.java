/**
 * 
 */
package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.QuestionDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.service.LoadQuestionService;

/**
 * @author lenovo
 *
 */
public class LoadQuestionServiceImpl implements LoadQuestionService {

	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.LoadQuestionService#LoadPopularQuestion()
	 */
	
	private 	QuestionDaoImpl questionDaoImpl = new QuestionDaoImpl();
	@Override
	public ArrayList<Question> LoadPopularQuestion() {
		// TODO Auto-generated method stub
		ResultSet resultSet = questionDaoImpl.SelectPopularQuestion();
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

	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.LoadQuestionService#LoadCategoryQuestion(int, int, int)
	 */
	@Override
	public ArrayList<Question> LoadCategoryQuestion(int type, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.LoadQuestionService#LoadUserQuestion(java.lang.String)
	 */
	@Override
	public ArrayList<Question> LoadUserQuestion(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
