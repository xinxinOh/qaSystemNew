package com.neuedu.QA.dao;

import java.sql.ResultSet;

public interface UserFollowDao {
	
	ResultSet SelectAllFollow(String user_id);
	int AddFollow(String user_id, String to_user_id);
	int DeleteFollow(String user_id, String to_user_id);
	
}

