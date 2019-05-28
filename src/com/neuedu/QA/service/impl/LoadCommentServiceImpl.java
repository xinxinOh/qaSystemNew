package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.CommentDaoImpl;
import com.neuedu.QA.dao.impl.SecondCommentDaoImpl;
import com.neuedu.QA.entity.Comment;
import com.neuedu.QA.service.LoadCommentService;

public class LoadCommentServiceImpl implements LoadCommentService{

	public SecondCommentDaoImpl secondCommentDaoImpl = new SecondCommentDaoImpl();
	public CommentDaoImpl commentDaoImpl = new CommentDaoImpl();
	
	@Override
	public ArrayList<Comment> LoadComment(int answer_id, int start, int end) {
		ArrayList<Comment> Comment_list = new ArrayList<Comment>();
		ResultSet rs = commentDaoImpl.SelectComment(answer_id, start, end);
		try {
			while(rs.next()) {
				Comment_list.add(new Comment(rs.getInt(1),rs.getInt(2),rs.getString(7),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getInt(6)));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Comment_list;
	}
	@Override
	public ArrayList<Comment> LoadSecondComment(int comment_id, int start, int end) {
		ArrayList<Comment> Comment_list = new ArrayList<Comment>();
		ResultSet rs_second_id = secondCommentDaoImpl.SelectSecondCommentID(comment_id, start, end);
		String str = "";
		int[] intArr;
		try {
			while(rs_second_id.next()) {
				str = str+rs_second_id.getInt(2)+" ";
			}
			rs_second_id.close();
			if(str.length() ==0) {
				return new ArrayList<Comment>();
			}
			str = str.substring(0,str.length() - 1);
			String[] valueArr = str.split(" ");
            intArr = new int[valueArr.length];
            for (int i = 0; i < valueArr.length; i++) {
                intArr[i] = Integer.parseInt(valueArr[i]);
            }
            
            ResultSet rs = commentDaoImpl.SelectSecondComment(intArr);
            
            while(rs.next()) {
				Comment_list.add(new Comment(rs.getInt(1),rs.getInt(2),rs.getString(7),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getInt(6)));
			}
            
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Comment_list;
	}
	
	@Override
	public ArrayList<Comment> LoadUserComment(String user_id) {
		ArrayList<Comment> Comment_list = new ArrayList<Comment>();
		ResultSet rs = commentDaoImpl.SelectUserComment(user_id);

		try {

            while(rs.next()) {
				Comment_list.add(new Comment(rs.getInt(1),rs.getInt(2),rs.getString(7),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getInt(6)));
			}
            
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Comment_list;
	}
	
	
	
}
