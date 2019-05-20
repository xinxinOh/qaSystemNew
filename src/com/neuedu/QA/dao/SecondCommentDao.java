package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.SecondComment;

public interface SecondCommentDao {
	
	ResultSet SelectSecondDiscussID(int discuss_id,int start,int end);
	int addSecondDiscuss(SecondComment sd);
	int deleteSecondDiscuss(int SecondDiscuss_id);

}
