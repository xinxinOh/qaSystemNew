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
		int ret=commentDaoImpl.addComment(comment);
		int second_comment_id = commentDaoImpl.SelectOne(comment.getUser_id(), comment.getContent());
		System.out.println(comment.getContent());
		SecondComment secondComment=new SecondComment();
		secondComment.setComment_id(comment_id);//被评论的评论的id
		secondComment.setSecond_comment_id(second_comment_id);//二级评论id
		int i=secondCommentDaoImpl.addSecondComment(secondComment);
		// TODO Auto-generated method stub
		return i;
		
	}

}
