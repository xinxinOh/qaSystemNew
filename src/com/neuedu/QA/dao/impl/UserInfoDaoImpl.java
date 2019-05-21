package com.neuedu.QA.dao.impl;


import com.neuedu.QA.dao.UserInfoDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.UserInfo;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	@Override
	public UserInfo SelectUser(String user_id) {
		String sql = "SELECT * FROM user_info where u_id=? "; // 检索记录行
		//SELECT * FROM user_info LIMIT 5;检索前五行记录
		Object[] param = new Object[]{user_id};
		return (UserInfo) executeSelect(sql,param);
	}

	@Override
	public Integer addUser(UserInfo userInfo) {
		String sql = "insert into user_info(u_id,password,nickname,birthdate,sex,age,introduction) values (?,?,?,?,?,?,?)";//insert into user_info(u_id,password,nickname,birthdate,sex,age,introduction) values (9,78,456,'2009-05-07','女',10,65235)
		Object[] param = new Object[]{userInfo.getUser_id(),userInfo.getPassword(),userInfo.getNickname(),userInfo.getBirthdate(),userInfo.getSex(),userInfo.getAge(),userInfo.getIntroduction()};
		return executeIUD(sql,param);

	}

	@Override
	public Integer updateUser(UserInfo userInfo) {
		String sql  = "UPDATE user_info SET password=9797  where u_id=3";
		Object[] param = new Object[]{userInfo.getUser_id(),userInfo.getPassword(),userInfo.getNickname(),userInfo.getBirthdate(),userInfo.getSex(),userInfo.getAge(),userInfo.getIntroduction()};
		return executeIUD(sql, param);
		
	}

	@Override
	public Integer deleteUser(String user_id) {
		String sql  = "delete from user_info where u_id=?";
		Object[] param = new Object[]{user_id};
		return executeIUD(sql, param);
	}

}
