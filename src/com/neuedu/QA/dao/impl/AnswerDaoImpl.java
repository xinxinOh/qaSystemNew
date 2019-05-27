package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;
import java.util.Date;

import com.neuedu.QA.dao.AnswerDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.Answer;
import com.neuedu.QA.entity.Question;

public class AnswerDaoImpl extends BaseDao implements AnswerDao{
	//public static void main(String[] args) {
		/*
		 * Date date1=new Date(System.currentTimeMillis()); Date date2=new
		 * Date(System.currentTimeMillis()); Date date3=new
		 * Date(System.currentTimeMillis()); Answer answer1=new Answer(null, 8, "479",
		 * "impossible", 12, 133, 2, date1); Answer answer2=new Answer(null, 9, "479",
		 * "impossible22", 11, 13, 6, date2); Answer answer3=new Answer(6, 8, "610",
		 * "update", 18, 23, 9, date3);
		 */
	
		//AnswerDaoImpl answerDaoImpl=new AnswerDaoImpl();
		//answerDaoImpl.addAnswer(answer1);
		/*
		 * answerDaoImpl.deleteAnswer(4); answerDaoImpl.deleteAnswer(5);
		 * answerDaoImpl.addAnswer(answer2); answerDaoImpl.addAnswer(answer3);
		 */
		/*
		 * ResultSet rs=answerDaoImpl.SelectAllAnswer("479"); try { for(;rs.next();) {
		 * System.out.println(rs.getInt(1)); System.out.println(rs.getInt(2));
		 * System.out.println(rs.getString(3)); System.out.println(rs.getString(4));
		 * System.out.println(); } }catch(Exception e){ e.printStackTrace(); }
		 */
		/*
		 * ResultSet rs=answerDaoImpl.SelectAnswer(8, 0, 10); try { for(;rs.next();) {
		 * System.out.println(rs.getInt(1)); System.out.println(rs.getInt(2));
		 * System.out.println(rs.getString(3)); System.out.println(rs.getString(4));
		 * System.out.println(); } }catch(Exception e){ e.printStackTrace(); }
		 */
		
		/*
		 * answerDaoImpl.updateAnswer(answer3); Answer
		 * answer4=answerDaoImpl.SelectOneAnswer(7);
		 * System.out.println(answer4.getContent());
		 */
		
	//}
			

	@Override
	public ResultSet SelectAnswer(int question_id, int start, int end) {//"提问页按分页显示回答"
		Object[] params =new Object[]{question_id,start,end};
		ResultSet rs = super.executeSelect("select * from answer where question_id=? order by comment_num desc LIMIT ?,?", params);
		//super.closeAll(BaseDao.con, BaseDao.pst, rs);
		return rs;
	}

	@Override
	public Answer SelectOneAnswer(int answer_id) {
		Object[] params =new Object[]{answer_id};
		ResultSet rs = super.executeSelect("select * from answer where answer_id=?", params);
		Answer answer=new Answer();
		try {
			if (rs.next()) {
				answer.setAnswer_id(rs.getInt(1));
				answer.setQuestion_id(rs.getInt(2));
				answer.setUser_id(rs.getString(3));
				answer.setContent(rs.getString(4));
				answer.setUpvote_num(rs.getInt(5));
				answer.setDownvote_num(rs.getInt(6));
				answer.setComment_num(rs.getInt(7));
				answer.setAnswer_date(rs.getDate(8));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return answer;
	}

	@Override
	public int addAnswer(Answer a) {
		Object[] params =new Object[]{a.getQuestion_id(),a.getUser_id(),a.getContent(),a.getUpvote_num(),a.getDownvote_num(),a.getComment_num(),a.getAnswer_date()};
		int i=super.executeIUD("insert into answer(question_id,u_id,content,upvote_num,downvote_num,comment_num,answer_date) values(?,?,?,?,?,?,?)", params);
		
		return i;
	}

	@Override
	public int updateAnswer(Answer a) {
		Object[] params =new Object[]{a.getQuestion_id(),a.getUser_id(),a.getContent(),a.getUpvote_num(),a.getDownvote_num(),a.getComment_num(),a.getAnswer_date(),a.getAnswer_id()};
		int i=super.executeIUD("UPDATE answer SET question_id=?, u_id=?,content=?,upvote_num=?,downvote_num=?,comment_num=?,answer_date=? WHERE answer_id=?", params);
		return i;
	}

	@Override
	public ResultSet SelectAllAnswer(String user_id, int start, int end) {
		Object[] params =new Object[]{user_id,start,end};
		ResultSet rs = executeSelect("select * from answer where u_id=? order by answer_date desc LIMIT ?,?", params);
		//super.closeAll(BaseDao.con, BaseDao.pst, rs);
		return rs;
	}

	@Override
	public int deleteAnswer(int Answer_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
