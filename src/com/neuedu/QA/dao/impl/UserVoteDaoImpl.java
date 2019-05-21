package com.neuedu.QA.dao.impl;

import com.neuedu.QA.dao.UserVoteDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.UserVote;

public class UserVoteDaoImpl extends BaseDao implements UserVoteDao {

	@Override
	public int addVote(UserVote UserVote) {
		String sql = "insert into user_vote(u_id,id,type,category) values (?,?,?,?)";
		Object[] param = new Object[]{UserVote};
		return executeIUD(sql,param);
	}
	
	@Override
	public int deleteVote(UserVote UserVote) {
		String sql  = "delete from user_vote where id=?";
		Object[] param = new Object[]{UserVote};
		return executeIUD(sql, param);
	}

}
