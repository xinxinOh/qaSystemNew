package com.neuedu.QA.entity;

public class UserFollow {
	
	private String user_id;
	private String follow_user_id;
	
	public UserFollow() {
		// TODO Auto-generated constructor stub
	}
	
	public UserFollow(String user_id , String follow_user_id) {
		this.user_id = user_id;
		this.follow_user_id = follow_user_id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFollow_user_id() {
		return follow_user_id;
	}
	public void setFollow_u_id(String follow_user_id) {
		this.follow_user_id = follow_user_id;
	}
	
}
