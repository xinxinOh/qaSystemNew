package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;

import com.neuedu.QA.dao.SecondCommentDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.SecondComment;

public class SecondCommentDaoImpl extends BaseDao implements SecondCommentDao {

	@Override
	public ResultSet SelectSecondCommentID(int comment_id, int start, int end) {
		
        Object[] params =new Object[]{comment_id,start,end-start};
		
		try {
		
			ResultSet rs = super.executeSelect("select * from second_comment where comment_id=? LIMIT ?,?", params);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
//			super.closeAll(BaseDao.con, BaseDao.pst, null);
		}
		return rs;

	}

	@Override
	public int addSecondComment(SecondComment sd) {
		
		Object[] params =new Object[]{sd.getComment_id(),sd.getSecond_comment_id()};
		int ret = super.executeIUD("insert second_comment (comment_id,second_comment_id) values (?,?);", params);
		return ret;
		
	}

	@Override
	public int deleteSecondComment(int SecondComment_id) {
		// TODO Auto-generated method stub
		Object[] params =new Object[]{SecondComment_id};
		int ret = super.executeIUD("DELETE FROM second_comment WHERE second_comment_id = ?" ,params);
		return ret;
		
	}


}
