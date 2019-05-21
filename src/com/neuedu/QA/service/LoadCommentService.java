package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Comment;

public interface LoadCommentService {
	
	ArrayList<Comment> LoadComment(int answer_id,int start,int end);
	ArrayList<Comment> LoadSecondComment(int discuss_id,int start,int end);
	ArrayList<Comment> LoadUserComment(String user_id);
	
}
