package com.neuedu.QA.dao;

import com.neuedu.QA.entity.UserVote;

public interface UserVoteDao {
	int addVote(UserVote UserVote);
	int deleteVote(UserVote UserVote);
	UserVote SelectVote(String user_id, int id, int type, int category);
}
