package com.neuedu.QA.service.impl;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.dao.impl.CommentDaoImpl;
import com.neuedu.QA.entity.UserVote;
import com.neuedu.QA.service.VoteService;

public class VoteServiceImpl implements VoteService{

	public AnswerDaoImpl answerDaoImpl=new AnswerDaoImpl();
	public CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
	public UserVote userVote=new UserVote();
	
	
	@Override
	public int updateAnswerOrComment(int ID, int type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userVote(String user_id, int id, int type, int category) {
		// TODO Auto-generated method stub
		return 0;
	}

}
