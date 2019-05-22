package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.CollectionInfoDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.service.CollectionService;

public class CollectionServiceImpl implements CollectionService {

	public CollectionInfoDaoImpl collectionInfo = new CollectionInfoDaoImpl();

	@Override
	public Integer addCollection(String user_id, int question_id) {
		// TODO Auto-generated method stub
		return collectionInfo.AddCollection(user_id, question_id);
	}

	@Override
	public Integer deleteCollection(String user_id, int question_id) {
		// TODO Auto-generated method stub
		return collectionInfo.DeleteCollection(user_id, question_id);
	}

	@Override
	public ArrayList<Question> showCollection(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		ResultSet resultSet = collectionInfo.showCollection(user_id, start, end);

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

	/*≤‚ ‘*/
	
	public static void main(String[] args) {
		//ÃÌº” ’≤ÿ
		//…æ≥˝ ’≤ÿ
		//∑÷“≥≤È’“ ’≤ÿ
	}
}
