package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Comment;

public interface UserCommentService {
	public int AddComment(Comment comment);
	public int AddSecondComment(Comment comment,int comment_id);
}
