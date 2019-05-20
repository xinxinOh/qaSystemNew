package com.neuedu.QA.entity;

public class UserVote {
	private String user_id;
	private int vote_to_id;
	private int vote_type;
	private int category;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getVote_to_id() {
		return vote_to_id;
	}
	public void setVote_to_id(int vote_to_id) {
		this.vote_to_id = vote_to_id;
	}
	public int getVote_type() {
		return vote_type;
	}
	public void setVote_type(int vote_type) {
		this.vote_type = vote_type;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
}
