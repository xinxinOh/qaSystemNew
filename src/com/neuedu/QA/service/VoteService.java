package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.UserVote;

public interface VoteService {
	//public int updateAnswerOrComment(int ID,int type);已用触发器实现了
	public int userVote(String user_id,int id,int type,int category);
	public int SelectVote(String user_id, int id, int type, int category);
	public ArrayList<UserVote> getAllVote(String user_id,  int type, int category);
}
