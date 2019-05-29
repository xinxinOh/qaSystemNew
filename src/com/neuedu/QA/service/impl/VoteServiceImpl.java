package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.UserVoteDaoImpl;
import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.entity.UserVote;
import com.neuedu.QA.service.VoteService;

public class VoteServiceImpl implements VoteService{

	//public AnswerDaoImpl answerDaoImpl=new AnswerDaoImpl();
	//public CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
	public UserVoteDaoImpl userVoteDaoImpl=new UserVoteDaoImpl();
	public UserVote userVote=new UserVote();
	
	//已用触发器实现了
	/*
	 * @Override public int updateAnswerOrComment(int ID, int type) { // TODO
	 * Auto-generated method stub return 0; }
	 */
	
	public int SelectVote(String user_id, int id, int type, int category){
		UserVote userVote = userVoteDaoImpl.SelectVote(user_id, id, type, category);
		if(userVote.getUser_id()==null||userVote.getUser_id().equals("")) {
			return 1;
		}
		
		return 0;
	}
	
	@Override
	public int userVote(String user_id, int id, int type, int category) {//category 0代表回答 1代表评论  type　0踩 1赞 2取消踩 3取消赞
		UserVote userVote=new UserVote(user_id, id, type, category);
		if(type==0||type==1) {//踩或赞 加入数据
			int i=userVoteDaoImpl.addVote(userVote);
			return i;
		}
		else if (type==2||type==3) {
			int i=userVoteDaoImpl.deleteVote(userVote);
			return i;
		}
		return 0;
	}
	
	public ArrayList<UserVote> getAllVote(String user_id,  int type, int category){
		ResultSet rs = userVoteDaoImpl.getAllVote(user_id,type,category);
		ArrayList<UserVote> list = new ArrayList<UserVote>();
		
		try {
			while(rs.next()) {
				list.add(new UserVote(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}
