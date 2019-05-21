package com.neuedu.QA.dao;

import java.sql.ResultSet;

public interface CollectionInfoDao {
	ResultSet SelectAllCollection(String user_id);
	int AddCollection(String user_id,int question_id);
	int DeleteCollection(String user_id,int question_id);
}
