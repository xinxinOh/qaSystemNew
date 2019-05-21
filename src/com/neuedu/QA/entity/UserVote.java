package com.neuedu.QA.entity;

public class UserVote {
	private String user_id;
	private Integer vote_to_id;
	private Integer vote_type;
	private Integer category;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getVote_to_id() {
		return vote_to_id;
	}
	public void setVote_to_id(Integer vote_to_id) {
		this.vote_to_id = vote_to_id;
	}
	public Integer getVote_type() {
		return vote_type;
	}
	public void setVote_type(Integer vote_type) {
		this.vote_type = vote_type;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
}
