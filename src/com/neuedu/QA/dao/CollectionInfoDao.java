package com.neuedu.QA.dao;

import java.sql.ResultSet;

public interface CollectionInfoDao {
	public ResultSet SelectAllCollection(int user_id);
	public int AddCollection(int user_id,int question_id);
	public int DeleteCollection(int user_id,int question_id);
}
