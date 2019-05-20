package com.neuedu.QA.dao;

import java.sql.ResultSet;

public interface CollectionInfoDao {
	ResultSet SelectAllCollection(int user_id);
	int AddCollection(int user_id,int question_id);
	int DeleteCollection(int user_id,int question_id);
}
