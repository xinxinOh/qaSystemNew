package com.neuedu.QA.dao.impl;


import java.sql.ResultSet;

import com.neuedu.QA.dao.UserInfoDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.UserInfo;


public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	@Override
	public UserInfo SelectUser(String user_id) {
		String sql = "SELECT * FROM user_info where u_id=? "; // 妫�绱㈣褰曡
		//SELECT * FROM user_info LIMIT 5;妫�绱㈠墠浜旇璁板綍
		Object[] param = new Object[]{user_id};
		ResultSet rs = executeSelect(sql,param);
		UserInfo userInfo=new UserInfo();
		try {
			if (rs.next()) {
				userInfo.setUser_id(rs.getString(1));
				userInfo.setPassword(rs.getString(2));
				/*
				 * userInfo.sets answer.setAnswer_id(rs.getInt(1));
				 * answer.setQuestion_id(rs.getInt(2)); answer.setUser_id(rs.getString(3));
				 * answer.setContent(rs.getString(4)); answer.setUpvote_num(rs.getInt(5));
				 * answer.setDownvote_num(rs.getInt(6)); answer.setComment_num(rs.getInt(7));
				 * answer.setAnswer_date(rs.getDate(8));
				 */
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return userInfo;
	}

	@Override
	public Integer addUser(UserInfo userInfo) {
		String sql = "insert into user_info(u_id,password,nickname,birthdate,sex,age,introduction) values (?,?,?,?,?,?,?)";//insert into user_info(u_id,password,nickname,birthdate,sex,age,introduction) values (9,78,456,'2009-05-07','濂�',10,65235)
		Object[] param = new Object[]{userInfo.getUser_id(),userInfo.getPassword(),userInfo.getNickname(),userInfo.getBirthdate(),userInfo.getSex(),userInfo.getAge(),userInfo.getIntroduction()};
		return executeIUD(sql,param);

	}

	@Override
	public Integer updateUser(UserInfo userInfo) {
		String sql  = "UPDATE user_info SET password=?,nickname=?,birthdate=?,sex=?,age=?,introduction=? where u_id=?";
		Object[] param = new Object[]{userInfo.getPassword(),userInfo.getNickname(),userInfo.getBirthdate(),userInfo.getSex(),userInfo.getAge(),userInfo.getIntroduction(),userInfo.getUser_id()};
		return executeIUD(sql, param);
		
	}

	@Override
	public Integer deleteUser(String user_id) {
		String sql  = "delete from user_info where u_id=?";
		Object[] param = new Object[]{user_id};
		return executeIUD(sql, param);
	}

}
