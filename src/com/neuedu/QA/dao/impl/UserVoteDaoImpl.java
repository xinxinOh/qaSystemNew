package com.neuedu.QA.dao.impl;

import com.neuedu.QA.dao.UserVoteDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.UserVote;

public class UserVoteDaoImpl extends BaseDao implements UserVoteDao {
	public static void main(String[] args) {
		UserVoteDaoImpl userVoteDaoImpl=new UserVoteDaoImpl();
		UserVote userVote=new UserVote("479", 11, 1, 1);
		userVoteDaoImpl.addVote(userVote);
	}

	@Override
	public int addVote(UserVote UserVote) {
		String sql = "insert into user_vote(u_id,id,type,category) values (?,?,?,?)";
		Object[] param = new Object[]{UserVote.getUser_id(),UserVote.getVote_to_id(),UserVote.getVote_type(),UserVote.getCategory()};
		return executeIUD(sql,param);
	}
	
	@Override
	public int deleteVote(UserVote UserVote) {
		String sql  = "delete from user_vote where u_id=?,id=?";
		Object[] param = new Object[]{UserVote.getUser_id(),UserVote.getVote_to_id()};
		return executeIUD(sql, param);
	}

}
