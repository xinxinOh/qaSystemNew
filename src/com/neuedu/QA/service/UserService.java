package com.neuedu.QA.service;

import com.neuedu.QA.entity.UserInfo;

public interface UserService {
	String Login(String id,String password);
	String Register(UserInfo userinfo);
	int modifyInfo(UserInfo userinfo);
	UserInfo selectUser(String user_id);
}
