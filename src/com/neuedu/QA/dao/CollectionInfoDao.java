package com.neuedu.QA.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CollectionInfoDao {
	ResultSet SelectAllCollection(String user_id);
	int AddCollection(String user_id,int question_id);
	int DeleteCollection(String user_id,int question_id);
	ResultSet showCollection(String user_id, int start, int end);
	int total(String param, Object value);
	ResultSet selectOneCollection(String user_id, int question_id);
}
