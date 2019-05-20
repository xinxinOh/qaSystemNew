package com.neuedu.QA.entity;

public class Collect {
	private String u_id;
	private Integer question_id;
	public Collect(String u_id, Integer question_id) {
		super();
		this.u_id = u_id;
		this.question_id = question_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	
}
