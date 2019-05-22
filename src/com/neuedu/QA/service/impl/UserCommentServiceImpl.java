package com.neuedu.QA.service.impl;

import com.neuedu.QA.dao.impl.CommentDaoImpl;
import com.neuedu.QA.dao.impl.SecondCommentDaoImpl;
import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.entity.SecondComment;
import com.neuedu.QA.service.UserCommentService;

public class UserCommentServiceImpl implements UserCommentService{

	public CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
	public SecondCommentDaoImpl secondCommentDaoImpl=new SecondCommentDaoImpl();
	
	@Override
	public int AddComment(Comment comment) {
		int i=commentDaoImpl.addComment(comment);
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public int AddSecondComment(Comment comment, int comment_id) {//comment_id是被评论的 评论的id（一级评论的id）
		SecondComment secondComment=new SecondComment();
		secondComment.setComment_id(comment_id);//被评论的评论的id
		secondComment.setSecond_comment_id(comment.getComment_id());//二级评论id
		int i=secondCommentDaoImpl.addSecondComment(secondComment);
		// TODO Auto-generated method stub
		return i;
	}

}
