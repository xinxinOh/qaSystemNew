package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dao.impl.CommentDaoImpl;
import com.neuedu.QA.dao.impl.SecondCommentDaoImpl;
import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.service.LoadCommentService;

public class LoadCommentServiceImpl implements LoadCommentService{

	public SecondCommentDaoImpl secondCommentDaoImpl = new SecondCommentDaoImpl();
	public CommentDaoImpl commentDaoImpl = new CommentDaoImpl();
	
	@Override
	public ArrayList<Comment> LoadComment(int answer_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comment> LoadSecondComment(int discuss_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comment> LoadUserComment(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
