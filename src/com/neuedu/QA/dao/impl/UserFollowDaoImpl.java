package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.UserFollowDao;
import com.neuedu.QA.dbutil.BaseDao;

public class UserFollowDaoImpl extends BaseDao implements UserFollowDao {
	
	@Override
	public ResultSet SelectFollow(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		
       Object[] params =new Object[]{user_id,start,end-start};
		

		String sql_1 = "select follow_u_id from user_follow where u_id = ? LIMIT ?,?";
		String sql = "select * from user_info where u_id in ("+sql_1+")";
		return executeSelect(sql, params);
	}
	
	@Override
	public int AddFollow(String user_id, String to_user_id) {
		// TODO Auto-generated method stub
		String sql = "insert into user_follow(u_id,follow_u_id) values(?,?)";
		String params[] = {user_id , to_user_id};
		return executeIUD(sql, params);
	}

	@Override
	public int DeleteFollow(String user_id, String to_user_id) {
		// TODO Auto-generated method stub
		//�������ݿⲻͨ��������mysql�ᱨ����Ҫ��set����safe����update����Ϊ0����ִ��
		String set_safe_0 = "set sql_safe_updates = 0;";
		//sql���
		String sql = "delete from user_follow where u_id = ? and follow_u_id = ?;";
		//�ָ���ȫ����
		String set_safe_1 = "set sql_safe_updates = 1;";
				
		String params[] = {user_id , to_user_id};
		return executeIUD(set_safe_0+sql+set_safe_1, params);
	}

}
