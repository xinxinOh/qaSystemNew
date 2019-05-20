package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.SecondComment;

public interface SecondCommentDao {
	
	public ResultSet SelectSecondCommentID(int comment_id,int start,int end);
	public int addSecondComment(SecondComment sd);
	public int deleteSecondComment(int SecondComment_id);

}
