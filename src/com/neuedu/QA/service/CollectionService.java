package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Question;

public interface CollectionService {

	public Integer addCollection(String user_id , int question_id);
	public Integer deleteCollection(String user_id , int question_id);
	public ArrayList<Question> showCollection(String user_id,int start ,int end);
	
}
