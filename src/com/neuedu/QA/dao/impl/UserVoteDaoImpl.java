package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.UserVoteDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.UserVote;

public class UserVoteDaoImpl extends BaseDao implements UserVoteDao {
	public static void main(String[] args) {
		UserVoteDaoImpl userVoteDaoImpl=new UserVoteDaoImpl();
		UserVote userVote=new UserVote("479", 11, 1, 1);
		userVoteDaoImpl.addVote(userVote);
	}

	
	public UserVote SelectVote(String user_id, int id, int type, int category) {
		
		Object[] params =new Object[]{user_id,id,type,category};
		ResultSet rs = super.executeSelect("select * from user_vote where u_id=? and id = ? and type =? and category=?", params);
		UserVote userVote=new UserVote();
		try {
			if (rs.next()) {
				userVote.setUser_id(rs.getString(1));
				userVote.setVote_to_id(rs.getInt(2));
				userVote.setVote_type(rs.getInt(3));
				userVote.setCategory(rs.getInt(4));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return userVote;
		
	}
	
	@Override
	public int addVote(UserVote UserVote) {
		String sql = "insert into user_vote(u_id,id,type,category) values (?,?,?,?)";
		Object[] param = new Object[]{UserVote.getUser_id(),UserVote.getVote_to_id(),UserVote.getVote_type(),UserVote.getCategory()};
		return executeIUD(sql,param);
	}
	
	@Override
	public int deleteVote(UserVote UserVote) {
		String sql  = "delete from user_vote where u_id=? and id=? and type=? and category=?";
		Object[] param = new Object[]{UserVote.getUser_id(),UserVote.getVote_to_id(),UserVote.getVote_type()-2,UserVote.getCategory()};
		return executeIUD(sql, param);
	}
	
	public ResultSet getAllVote(String user_id, int type, int category) {
		
		Object[] params =new Object[]{user_id,type,category};
		ResultSet rs = super.executeSelect("select * from user_vote where u_id=? and type =? and category=?", params);
		return rs;
		
	}

}
