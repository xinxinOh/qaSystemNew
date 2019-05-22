package com.neuedu.QA.service.impl;

import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.UserService;

public class UserServiceImpl implements UserService{
	
	public UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
	
	
	@Override
	public String Login(String id, String password) {
		
		UserInfo userInfo = userInfoDaoImpl.SelectUser(id);
		
		if(userInfo.getUser_id().equals("") || userInfo.getUser_id() == null) {
			
			return "0 "+"�û���������";
			
		}
		
        if(userInfo.getUser_id().equals(id) && !userInfo.getPassword().equals(password)) {
			
			return "0 "+"�������";
			
		}
        
        if(userInfo.getUser_id().equals(id) && userInfo.getPassword().equals(password)) {
			
			return "1 "+id;
			
		} 
		
		return "0 "+"����δ֪����";
	}

	@Override
	public String Register(UserInfo userinfo) {
		
		int ret = userInfoDaoImpl.addUser(userinfo);
		
		if(ret==1) {
			return "1"+ " "+ "ע��ɹ�";
		}
		else {
			return "0"+ " "+ "ע��ʧ��";
		}
	}

	@Override
	public int modifyInfo(UserInfo userinfo) {
		
		int ret = userInfoDaoImpl.updateUser(userinfo);
		
		return ret;
	}
	
}
