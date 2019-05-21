package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.CommentDao;
import com.neuedu.QA.entity.Comment;

public class CommentDaoImpl implements CommentDao{

	@Override
	public ResultSet SelectComment(int answer_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet SelectSecondComment(int[] secondComment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet SelectUserComment(int User_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment SelectOneComment(int comment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addComment(Comment d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateComment(Comment d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment(int Comment_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
