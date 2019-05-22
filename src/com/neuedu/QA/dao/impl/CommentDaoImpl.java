package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;
import java.util.Date;

import com.neuedu.QA.dao.CommentDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.Comment;

public class CommentDaoImpl extends BaseDao implements CommentDao{

	@Override
	public ResultSet SelectComment(int answer_id, int start, int end) {
		
		Object[] params =new Object[]{answer_id,start,end-start};
		
		try {
		
			ResultSet rs = super.executeSelect("select * from comment where answer_id=? LIMIT ?,?", params);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
//			super.closeAll(BaseDao.con, BaseDao.pst, null);
		}
		return rs;
		
	}

	@Override
	public ResultSet SelectSecondComment(int[] secondComment_id) {
		
		String str = "";
		for(int i=0;i<secondComment_id.length;i++){
			str = str + secondComment_id[i] +",";
		}
		
        Object[] params =new Object[]{};

		try {
		
			ResultSet rs = super.executeSelect("select * from comment where comment_id in "+"("+str.substring(0,str.length() - 1)+")", params);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
//			super.closeAll(BaseDao.con, BaseDao.pst, null);
		}
		return rs;
		
	}

	@Override
	public ResultSet SelectUserComment(String User_id) {
		
        Object[] params =new Object[]{User_id};

		try {
		
			ResultSet rs = super.executeSelect("select * from comment where u_id = ? ", params);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
//			super.closeAll(BaseDao.con, BaseDao.pst, null);
		}
		return rs;
		
	}

	@Override
	public Comment SelectOneComment(int comment_id) {

		Object[] params =new Object[]{comment_id};
		Comment c = new Comment(null,null,null,null,null,null,null);
		try {
		
			ResultSet rs = super.executeSelect("select * from comment where comment_id = ? ", params);
			
			if(rs.next()) {
				c.setAnswer_id(rs.getInt(2));
				c.setContent(rs.getString(3));
				c.setComment_id(rs.getInt(1));
				c.setDisscuss_date(rs.getDate(4));
				c.setDownvote_num(rs.getInt(6));
				c.setUpvote_num(rs.getInt(5));
				c.setUser_id(rs.getString(7));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
//			super.closeAll(BaseDao.con, BaseDao.pst, null);
		}
		return c;

	}

	@Override
	public int addComment(Comment c) {

		Object[] params =new Object[]{c.getAnswer_id(),c.getContent(),c.getDisscuss_date(),c.getUpvote_num(),c.getDownvote_num(),c.getUser_id()};
		int ret = super.executeIUD("insert comment (comment_id,answer_id,content,discuss_date,upvote_num,downvote_num,u_id) values (0,?,?,?,?,?,?);", params);
		return ret;
		
	}

	@Override
	public int updateComment(Comment c) {
		
		Object[] params =new Object[]{c.getContent(),c.getDisscuss_date(),c.getComment_id()};
		int ret = super.executeIUD("UPDATE comment SET content=?,discuss_date=? WHERE comment_id = ?;", params);
		return ret;
	}

	@Override
	public int deleteComment(int Comment_id) {
		
		Object[] params =new Object[]{Comment_id};
		int ret = super.executeIUD("DELETE FROM comment WHERE comment_id = ?" ,params);
		return ret;
		
	}
	
	

}
