package com.neuedu.QA.dao;

import com.neuedu.QA.entity.UserInfo;

public interface UserInfoDao {
	UserInfo SelectUser(String user_id);
	Integer addUser(UserInfo userInfo);
	Integer updateUser(UserInfo userInfo);
	Integer deleteUser(String user_id);
}
