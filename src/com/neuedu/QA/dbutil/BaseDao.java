package com.neuedu.QA.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 锟斤拷锟斤拷锟斤拷
 * @author Administrator
 *
 */
public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/qasys";
	private String user="root";
	private String pwd="ddd123";
	public static Connection con=null;
	public static PreparedStatement pst =null;
	public static ResultSet rs = null;
	
	/**
	 * 锟斤拷取锟结话锟侥凤拷锟斤拷
	 * @return
	 */
	public Connection getCon(){
		try {
			Class.forName(driver);//加载mysql驱动
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接建立失败");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * 锟斤拷锟矫的关闭革拷锟斤拷jdbc锟斤拷锟斤拷姆锟斤拷锟�
	 * @param con
	 * @param st
	 * @param rs
	 */
	public void closeAll(Connection con,Statement st,ResultSet rs){
		try {
			if(null!=rs){
				rs.close();
			}
			if (null!=st) {
				st.close();
			}
			if (null!=con) {
				con.close();
			}
		} catch (Exception e2) {
			System.out.println("锟截憋拷锟斤拷锟捷匡拷失锟斤拷");
			e2.printStackTrace();
		}
		
	}
	
	/**
	 * 锟斤拷锟斤拷删锟侥的诧拷锟斤拷锟斤拷取锟缴癸拷通锟侥凤拷锟斤拷
	 * @return int 锟斤拷示影锟斤拷锟斤拷锟斤拷锟�
	 */
	
	public int executeIUD(String sql , Object[] params){
		PreparedStatement pst =null;//预锟斤拷锟斤拷sql锟斤拷锟斤拷锟斤拷
		con = getCon();//通锟斤拷锟斤拷通锟斤拷锟斤拷锟矫碉拷锟斤拷锟捷匡拷锟斤拷锟斤拷
		int count =0;//锟斤拷锟斤拷影锟斤拷锟斤拷锟斤拷锟侥憋拷锟斤拷
		try {
			pst=con.prepareStatement(sql);
			//拼锟接诧拷锟斤拷  ,一锟斤拷?锟斤拷应一锟斤拷锟斤拷锟斤拷
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//为sql锟叫碉拷每一锟斤拷?锟斤拷值
				}
			}
			
			count=pst.executeUpdate();//PreparedStatement锟斤拷锟斤拷删锟侥凤拷锟斤拷
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con,pst,null);
		}
		
		return count;
	}
	
	/**
	 * 锟斤拷通锟侥诧拷询锟斤拷锟斤拷,锟斤拷锟斤拷值锟角斤拷锟斤拷锟�
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeSelect(String sql , Object[] params){
		con = getCon();//通锟斤拷锟斤拷通锟斤拷锟斤拷锟矫碉拷锟斤拷锟捷匡拷锟斤拷锟斤拷
		try {
			pst=con.prepareStatement(sql);
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//为sql锟叫碉拷每一锟斤拷?锟斤拷值
				}
			}
			
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//锟斤拷锟斤拷注锟解不锟杰碉拷锟斤拷closeAll锟斤拷锟斤拷,锟斤拷然锟斤拷锟节得诧拷锟斤拷rs锟叫碉拷值哦
		}
		
		return rs;
	}
	
	
	public static void main(String[] args) {
		BaseDao bb = new BaseDao();
		bb.getCon();
	}
	
}
