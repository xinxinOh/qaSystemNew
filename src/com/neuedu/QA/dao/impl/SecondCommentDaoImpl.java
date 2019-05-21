package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.SecondCommentDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.SecondComment;

public class SecondCommentDaoImpl extends BaseDao implements SecondCommentDao{

	@Override
	public ResultSet SelectSecondCommentID(int comment_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addSecondComment(SecondComment sd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSecondComment(int SecondComment_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
