package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Collect;

public interface CollectionService {

	public Integer addCollection(int user_id , int question_id);
	public Integer deleteCollection(int user_id , int question_id);
	public ArrayList<Collect> showCollection(int user_id,int start ,int end);
	
}
