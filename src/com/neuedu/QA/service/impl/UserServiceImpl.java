package com.neuedu.QA.service.impl;

import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.UserService;

public class UserServiceImpl implements UserService{
	
	public UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
	
	
	@Override
	public String Login(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Register(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
