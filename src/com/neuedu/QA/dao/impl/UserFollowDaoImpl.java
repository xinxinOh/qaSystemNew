package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.UserFollowDao;
import com.neuedu.QA.dbutil.BaseDao;

public class UserFollowDaoImpl extends BaseDao implements UserFollowDao {

	@Override
	public ResultSet SelectAllFollow(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int AddFollow(int user_id, int to_user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteFollow(int user_id, int to_user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
