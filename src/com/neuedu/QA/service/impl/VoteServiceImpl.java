package com.neuedu.QA.service.impl;

import com.neuedu.QA.dao.impl.AnswerDaoImpl;
import com.neuedu.QA.dao.impl.CommentDaoImpl;
import com.neuedu.QA.entity.UserVote;
import com.neuedu.QA.service.VoteService;

public class VoteServiceImpl implements VoteService{
	AnswerDaoImpl answerDaoImpl=new AnswerDaoImpl();
	CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
	UserVote userVote=new UserVote();
	

	@Override
	public int updateAnswerOrComment(int ID, int type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userVote(int user_id, int id, int type, int category) {
		// TODO Auto-generated method stub
		return 0;
	}

}
