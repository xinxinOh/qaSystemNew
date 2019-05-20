package com.neuedu.QA.dao;

import com.neuedu.QA.entity.UserInfo;

public interface UserInfoDAO {
	public UserInfo SelectUser(String user_id);
	public Integer addUser(UserInfo userInfo);
	public Integer updateUser(UserInfo userInfo);
	public Integer deleteUser(String user_id);
}
