package com.neuedu.QA.service;

public interface VoteService {
	public int updateAnswerOrComment(int ID,int type);
	public int userVote(String user_id,int id,int type,int category);
}
