package com.neuedu.QA.service;

public interface VoteService {
	public int updateAnswerOrComment(int ID,int type);
	public int userVote(int user_id,int id,int type,int category);
}
