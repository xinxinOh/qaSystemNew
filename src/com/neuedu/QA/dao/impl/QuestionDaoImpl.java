package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.neuedu.QA.dao.QuestionDao;
import com.neuedu.QA.dbutil.BaseDao;
import com.neuedu.QA.entity.Question;

public class QuestionDaoImpl extends BaseDao implements QuestionDao {
	//sdfadfaf
	//@SuppressWarnings("deprecation")
	//public static void main(String[] args) {
		//UserInfo user=new UserInfo(null, "11", "wxx", "hello");
		//UserInfo user2=new UserInfo(null, "11", "zzj", "hello byebye");
		/*
		 * Date date1=new Date(System.currentTimeMillis()); Date date2=new
		 * Date(System.currentTimeMillis()); Date date3=new
		 * Date(System.currentTimeMillis()); Question question=new Question(null,
		 * "479","hello1", "world4",12, 2, 1, date1, 1); Question question1=new
		 * Question(null,"479","hello2", "world4",14, 3, 2, date2, 1); Question
		 * question2=new Question(9, "610","hello2", "world6",1, 7, 4, date3, 2);
		 */
		
		//QuestionDaoImpl questionDaoImpl=new QuestionDaoImpl();
		//questionDaoImpl.addQuestion(question);
		//questionDaoImpl.addQuestion(question1);
		//questionDaoImpl.addQuestion(question2);
		//question2.setContent("update");
		//questionDaoImpl.updateQuestion(question2);
		/*
		 * questionDaoImpl.deleteQuestion(1); questionDaoImpl.deleteQuestion(2);
		 * questionDaoImpl.deleteQuestion(3); questionDaoImpl.deleteQuestion(4);
		 * questionDaoImpl.deleteQuestion(5); questionDaoImpl.deleteQuestion(6);
		 */
		/*
		 * ResultSet rs=questionDaoImpl.SelectAllQuestion("479"); try { for(;rs.next();)
		 * { System.out.println(rs.getInt(1)); System.out.println(rs.getString(2));
		 * System.out.println(rs.getString(3)); System.out.println(rs.getString(4));
		 * System.out.println(); } }catch(Exception e){ e.printStackTrace(); }
		 */
		/*
		 * ResultSet rs=questionDaoImpl.SelectLoadQuestion(2, 0, 10); try {
		 * for(;rs.next();) { System.out.println(rs.getInt(1));
		 * System.out.println(rs.getString(2)); System.out.println(rs.getString(3));
		 * System.out.println(rs.getString(4)); System.out.println(); } }
		 * catch(Exception e){ e.printStackTrace(); }
		 */
		/*
		 * ResultSet rs=questionDaoImpl.SelectPopularQuestion(); try { for(;rs.next();)
		 * { System.out.println(rs.getInt(1)); System.out.println(rs.getString(2));
		 * System.out.println(rs.getString(3)); System.out.println(rs.getString(4));
		 * System.out.println(); } } catch(Exception e){ e.printStackTrace(); }
		 */
		
	//}

	@Override
	public ResultSet SelectAllQuestion(String user_id) {//“我提问过的问题”
		Object[] params =new Object[]{user_id};
		ResultSet rs = super.executeSelect("select * from question where u_id=? order by question_date desc", params);
		//super.closeAll(BaseDao.con, BaseDao.pst, rs);
		return rs;
	}

	@Override
	public ResultSet SelectPopularQuestion() {//"首页 右侧 显示热门问题"
		Object[] params =new Object[]{};
		ResultSet rs = super.executeSelect("select * from question  order by fever desc LIMIT 10", params);
		//super.closeAll(BaseDao.con, BaseDao.pst, rs);
		return rs;
	}

	@Override
	public ResultSet SelectLoadQuestion(Integer type, int start, int end) {//"首页 按分类和热度 分页显示问题"
		Object[] params =new Object[]{type,start,end};
		ResultSet rs = super.executeSelect("select * from question where type=? order by fever desc LIMIT ?,?", params);
		//super.closeAll(BaseDao.con, BaseDao.pst, rs);
		return rs;
	}

	@Override
	public Question selectQuestion(Integer question_id) {
		Object[] params =new Object[]{question_id};
		ResultSet rs = super.executeSelect("select * from question where question_id=?", params);
		Question question=new Question();
		try {
			if (rs.next()) {
				question.setQuestion_id(rs.getInt(1));
				question.setUser_id(rs.getString(2));
				question.setTitle(rs.getString(3));
				question.setContent(rs.getString(4));
				question.setFever(rs.getInt(5));
				question.setAnswer_num(rs.getInt(6));
				question.setCollect_num(rs.getInt(7));
				question.setQuestion_date(rs.getDate(8));
				question.setType(rs.getInt(9));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);
		}
		return question;
	}

	@Override
	public Integer addQuestion(Question q) {
		Object[] params =new Object[]{q.getUser_id(),q.getTitle(),q.getContent(),q.getFever(),q.getAnswer_num(),q.getCollect_num(),q.getQuestion_date(),q.getType()};
		int i=super.executeIUD("insert into question(u_id,title,content,fever,answer_num,collect_num,question_date,type) values(?,?,?,?,?,?,?,?)", params);
		
		return i;
	}

	@Override
	public Integer updateQuestion(Question q) {
		Object[] params =new Object[]{q.getUser_id(),q.getTitle(),q.getContent(),q.getFever(),q.getAnswer_num(),q.getCollect_num(),q.getQuestion_date(),q.getType(),q.getQuestion_id()};
		int i=super.executeIUD("UPDATE question SET u_id=?,title=?,content=?,fever=?,answer_num=?,collect_num=?,question_date=?,type=? WHERE question_id=?", params);
		return i;
	}

	@Override
	public Integer deleteQuestion(Integer question_id) {
		Object[] params =new Object[]{question_id};
		int i=super.executeIUD("delete from question where question_id=?", params);
		return i;
	}

}
