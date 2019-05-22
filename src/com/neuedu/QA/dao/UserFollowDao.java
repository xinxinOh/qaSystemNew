package com.neuedu.QA.dao;

import java.sql.ResultSet;

public interface UserFollowDao {
	
	ResultSet SelectFollow(String user_id, int start, int end);
	int AddFollow(String user_id, String to_user_id);
	int DeleteFollow(String user_id, String to_user_id);
	
}

