package com.neuedu.QA.dao;

import com.neuedu.QA.entity.UserVote;

public interface UserVoteDao {
	int addVote(UserVote UserVote);
	int deleteVote(UserVote UserVote);
}
