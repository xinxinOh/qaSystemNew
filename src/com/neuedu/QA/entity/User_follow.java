package com.neuedu.QA.entity;

public class User_follow {
	
	private String u_id;
	private String follow_u_id;
	
	public User_follow() {
		// TODO Auto-generated constructor stub
	}
	
	public User_follow(String u_id , String follow_u_id) {
		this.u_id = u_id;
		this.follow_u_id = follow_u_id;
	}
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getFollow_u_id() {
		return follow_u_id;
	}
	public void setFollow_u_id(String follow_u_id) {
		this.follow_u_id = follow_u_id;
	}
	
}
