package com.neuedu.QA.service;

public interface VoteService {
	//public int updateAnswerOrComment(int ID,int type);���ô�����ʵ����
	public int userVote(String user_id,int id,int type,int category);
	public int SelectVote(String user_id, int id, int type, int category);
}
