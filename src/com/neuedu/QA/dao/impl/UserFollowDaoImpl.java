package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.UserFollowDao;
import com.neuedu.QA.dbutil.BaseDao;

public class UserFollowDaoImpl extends BaseDao implements UserFollowDao {
	
	@Override
	public ResultSet SelectFollow(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		
        Object[] params =new Object[]{user_id,start,end-start};
		

		String sql = "select * from user_follow where follow_u_id in ( select sc.follow_u_id from (select follow_u_id from user_follow where u_id = ? LIMIT ?,?) as sc)";
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
		//锟斤拷锟斤拷锟斤拷锟捷库不通锟斤拷锟斤拷锟斤拷锟斤拷mysql锟结报锟斤拷锟斤拷要锟斤拷set锟斤拷锟斤拷safe锟斤拷锟斤拷update锟斤拷锟斤拷为0锟斤拷锟斤拷执锟斤拷

		//sql锟斤拷锟�
		String sql = "delete from user_follow where u_id = ? and follow_u_id = ?;";
		//锟街革拷锟斤拷全锟斤拷锟斤拷

				
		String params[] = {user_id , to_user_id};
		return executeIUD(sql, params);
	}

}
