package com.neuedu.QA.dao;

import java.sql.ResultSet;

public interface UserFollowDao {
	
	ResultSet SelectAllFollow(int user_id);
	int AddFollow(int user_id, int to_user_id);
	int DeleteFollow(int user_id, int to_user_id);
	
}

