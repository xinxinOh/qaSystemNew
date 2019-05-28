package com.neuedu.QA.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
 * @author Administrator
 *
 */
public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/qasys?useUnicode=true&characterEncoding=utf-8&useSSL=true";
	private String user="root";
	private String pwd="";
	public static Connection con=null;
	public static PreparedStatement pst =null;
	public static ResultSet rs = null;
	
	/**
	 * 閿熸枻鎷峰彇閿熺粨璇濋敓渚ュ嚖鎷烽敓鏂ゆ嫹
	 * @return
	 */
	public Connection getCon(){
		try {
			Class.forName(driver);//鍔犺浇mysql椹卞姩
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("椹卞姩鍔犺浇澶辫触");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("杩炴帴寤虹珛澶辫触");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * 閿熸枻鎷烽敓鐭殑鍏抽棴闈╂嫹閿熸枻鎷穓dbc閿熸枻鎷烽敓鏂ゆ嫹濮嗛敓鏂ゆ嫹閿燂拷
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
			System.out.println("閿熸埅鎲嬫嫹閿熸枻鎷烽敓鎹峰尅鎷峰け閿熸枻鎷�");
			e2.printStackTrace();
		}
		
	}
	
	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹鍒犻敓渚ョ殑璇ф嫹閿熸枻鎷烽敓鏂ゆ嫹鍙栭敓缂寸櫢鎷烽�氶敓渚ュ嚖鎷烽敓鏂ゆ嫹
	 * @return int 閿熸枻鎷风ず褰遍敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
	 */
	
	public int executeIUD(String sql , Object[] params){
		PreparedStatement pst =null;//棰勯敓鏂ゆ嫹閿熸枻鎷穝ql閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
		con = getCon();//閫氶敓鏂ゆ嫹閿熸枻鎷烽�氶敓鏂ゆ嫹閿熸枻鎷烽敓鐭鎷烽敓鏂ゆ嫹閿熸嵎鍖℃嫹閿熸枻鎷烽敓鏂ゆ嫹
		int count =0;//閿熸枻鎷烽敓鏂ゆ嫹褰遍敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熶茎鎲嬫嫹閿熸枻鎷�
		try {
			pst=con.prepareStatement(sql);
			//鎷奸敓鎺ヨ鎷烽敓鏂ゆ嫹  ,涓�閿熸枻鎷�?閿熸枻鎷峰簲涓�閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//涓簊ql閿熷彨纰夋嫹姣忎竴閿熸枻鎷�?閿熸枻鎷峰��
				}
			}
			
			count=pst.executeUpdate();//PreparedStatement閿熸枻鎷烽敓鏂ゆ嫹鍒犻敓渚ュ嚖鎷烽敓鏂ゆ嫹
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con,pst,null);
		}
		
		return count;
	}
	
	/**
	 * 閿熸枻鎷烽�氶敓渚ヨ鎷疯閿熸枻鎷烽敓鏂ゆ嫹,閿熸枻鎷烽敓鏂ゆ嫹鍊奸敓瑙掓枻鎷烽敓鏂ゆ嫹閿燂拷
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeSelect(String sql , Object[] params){
		con = getCon();//閫氶敓鏂ゆ嫹閿熸枻鎷烽�氶敓鏂ゆ嫹閿熸枻鎷烽敓鐭鎷烽敓鏂ゆ嫹閿熸嵎鍖℃嫹閿熸枻鎷烽敓鏂ゆ嫹
		try {
			pst=con.prepareStatement(sql);
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//涓簊ql閿熷彨纰夋嫹姣忎竴閿熸枻鎷�?閿熸枻鎷峰��
				}
			}
			
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//閿熸枻鎷烽敓鏂ゆ嫹娉ㄩ敓瑙ｄ笉閿熸澃纰夋嫹閿熸枻鎷穋loseAll閿熸枻鎷烽敓鏂ゆ嫹,閿熸枻鎷风劧閿熸枻鎷烽敓鑺傚緱璇ф嫹閿熸枻鎷穜s閿熷彨纰夋嫹鍊煎摝
		}
		
		return rs;
	}
	
	
	public static void main(String[] args) {
		BaseDao bb = new BaseDao();
		bb.getCon();
	}

}
