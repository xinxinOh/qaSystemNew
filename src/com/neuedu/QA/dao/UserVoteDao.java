package com.neuedu.QA.dao;

import com.neuedu.QA.entity.UserVote;

public interface UserVoteDao {
	public int addVote(UserVote UserVote);
	public int deleteVote(UserVote UserVote);
}
