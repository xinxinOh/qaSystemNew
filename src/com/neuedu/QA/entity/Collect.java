package com.neuedu.QA.entity;

public class Collect {
	private String user_id;
	private Integer question_id;
	public Collect(String user_id, Integer question_id) {
		super();
		this.user_id = user_id;
		this.question_id = question_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	
}
