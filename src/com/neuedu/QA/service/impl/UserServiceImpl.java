package com.neuedu.QA.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.ResultSet;

import com.neuedu.QA.dao.impl.UserInfoDaoImpl;
import com.neuedu.QA.entity.UserInfo;
import com.neuedu.QA.service.UserService;


public class UserServiceImpl implements UserService{
	
	public UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
	
	  String getMD5String(String a) {
	        try {
	            // 鐢熸垚涓�涓狹D5鍔犲瘑璁＄畻鎽樿
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 璁＄畻md5鍑芥暟
	            md.update(a.getBytes());
	            // digest()鏈�鍚庣‘瀹氳繑鍥瀖d5 hash鍊硷紝杩斿洖鍊间负8浣嶅瓧绗︿覆銆傚洜涓簃d5 hash鍊兼槸16浣嶇殑hex鍊硷紝瀹為檯涓婂氨鏄�8浣嶇殑瀛楃
	            // BigInteger鍑芥暟鍒欏皢8浣嶇殑瀛楃涓茶浆鎹㈡垚16浣峢ex鍊硷紝鐢ㄥ瓧绗︿覆鏉ヨ〃绀猴紱寰楀埌瀛楃涓插舰寮忕殑hash鍊�
	            //涓�涓猙yte鏄叓浣嶄簩杩涘埗锛屼篃灏辨槸2浣嶅崄鍏繘鍒跺瓧绗︼紙2鐨�8娆℃柟绛変簬16鐨�2娆℃柟锛�
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
			
			return "0 "+"锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷";
			
		}
		
        if(userInfo.getUser_id().equals(id) && !userInfo.getPassword().equals(password)) {
			
			return "0 "+"锟斤拷锟斤拷锟斤拷锟�";			
		}
        
        if(userInfo.getUser_id().equals(id) && userInfo.getPassword().equals(password)) {
			
			return "1 "+id;			
		} 
		
		return "0 "+"锟斤拷锟斤拷未知锟斤拷锟斤拷";
	}
	
	
	@Override
	public String Register(UserInfo userinfo) {
		String newword=getMD5String(userinfo.getPassword());
		userinfo.setPassword(newword);
		System.out.println(newword);

		//灏嗗瘑鐮佽繘琛宮d5鍔犲瘑  锛岀劧鍚庡啀缁欏ス鏀惧湪userinfo瀹炰緥閲�
		int ret = userInfoDaoImpl.addUser(userinfo);
		
		if(ret==1) {
			return "1"+ " "+ "注锟斤拷晒锟�";
		}
		else {
			return "0"+ " "+ "注锟斤拷失锟斤拷";
		}
	}

	@Override
	public int modifyInfo(UserInfo userinfo) {
		
		int ret = userInfoDaoImpl.updateUser(userinfo);
		
		return ret;
	}

	@Override
	public UserInfo selectUser(String user_id) {
		// TODO Auto-generated method stub
		return  userInfoDaoImpl.SelectUser(user_id);
	}
	
}
