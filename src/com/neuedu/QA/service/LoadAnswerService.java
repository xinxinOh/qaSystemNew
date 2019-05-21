package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Question;

public interface LoadAnswerService {
	
	ArrayList<Question> LoadPopularQuestion();
	ArrayList<Question> LoadCategoryQuestion(int type,int start,int end);
	ArrayList<Question> LoadUserCenterQuestion(String user_id);
	
}
