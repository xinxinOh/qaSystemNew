package com.neuedu.QA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.QA.dao.CollectionInfoDao;
import com.neuedu.QA.dbutil.BaseDao;

public class CollectionInfoDaoImpl extends BaseDao implements CollectionInfoDao {

	@Override
	public ResultSet SelectAllCollection(String user_id) {
		// TODO Auto-generated method stub
		String sql_1 = "select question_id from collect where u_id = ?";
		String sql = "select * from question where question_id in ("+sql_1+")";
		Object[] params =new Object[]{user_id};
		return executeSelect(sql, params);
	}

	@Override
	public ResultSet selectOneCollection(String user_id, int question_id) {
		// TODO Auto-generated method stub
		String sql = "select * from collect where u_id = ? and question_id=?";
		Object[] params =new Object[]{user_id,question_id};
		return executeSelect(sql, params);
	}
	
	@Override
	public int AddCollection(String user_id, int question_id) {
		// TODO Auto-generated method stub
		ResultSet rs=selectOneCollection(user_id, question_id);
		System.out.println("rs: "+rs);
		try {
			if(rs.next()) {
				return 0;
			}
			else {
				String sql = "insert into collect (u_id,question_id) values(?,?)";
				Object[] params =new Object[]{user_id,question_id};
				return executeIUD(sql, params);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int DeleteCollection(String user_id, int question_id) {
		// TODO Auto-generated method stub//更新数据库不通过主键，mysql会报错，需要把set——safe——update设置为0才能执行
		//String set_safe_0 = "set sql_safe_updates = 0;";
		//sql语句
		String sql = "delete from collect where u_id = ? and question_id = ?;";
		//恢复安全设置
		//String set_safe_1 = "set sql_safe_updates = 1;";
				
		Object[] params =new Object[]{user_id,question_id};
		return executeIUD(sql, params);
	}

	@Override
	public ResultSet showCollection(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		String sql_1 = "select question_id from collect where u_id = ? ";
		String sql = "select * from question where question_id in("+sql_1+") order by question_id desc LIMIT ?,?";
		Object params[] = {user_id,start,end};
		return executeSelect(sql, params);
	}
	
	@Override
	public int total(String param, Object value) {
		Object[]params = new Object[] {value};
		int ans = 0;
		try {
			ResultSet resultSet = executeSelect("select count(u_id) from collect where "+param+" = ?", params);
			resultSet.next();
			ans = resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

}
