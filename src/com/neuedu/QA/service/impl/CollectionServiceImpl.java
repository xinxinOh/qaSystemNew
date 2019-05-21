package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dao.impl.CollectionInfoDaoImpl;
import com.neuedu.QA.entity.Collect;
import com.neuedu.QA.service.CollectionService;

public class CollectionServiceImpl implements CollectionService {

	private CollectionInfoDaoImpl collectionInfo;
	
	public CollectionServiceImpl() {
		// TODO Auto-generated constructor stub
		collectionInfo = new CollectionInfoDaoImpl();
	}
	
	@Override
	public Integer addCollection(int user_id, int question_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteCollection(int user_id, int question_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Collect> showCollection(int user_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
