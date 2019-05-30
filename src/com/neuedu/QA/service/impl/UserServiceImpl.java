package com.neuedu.QA.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.UserService;


public class UserServiceImpl implements UserService{
	
	public UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
	
	  String getMD5String(String a) {
	        try {
	            // 生成一个MD5加密计算摘要
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 计算md5函数
	            md.update(a.getBytes());
	            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
	            return new BigInteger(1, md.digest()).toString(16);
	        } catch (Exception e) {
	           e.printStackTrace();
	           return null;
	        }
		}
	
	@Override
	public String Login(String id, String password) {
		String pwd = getMD5String(password);
		password = pwd;
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
		String newword=getMD5String(userinfo.getPassword());
		userinfo.setPassword(newword);
		System.out.println(newword);

		//将密码进行md5加密  ，然后再给她放在userinfo实例里
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
