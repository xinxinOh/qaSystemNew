package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Answer;

public interface LoadAnswerService {
	
	ArrayList<Answer> LoadAnswer(int question_id,int start,int end);
	ArrayList<Answer> LoadUserCenterAnswer(String user_id , int start ,int end);
	
}
