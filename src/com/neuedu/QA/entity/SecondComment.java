package com.neuedu.QA.entity;

public class SecondComment {

	private Integer comment_id;
	private Integer second_comment_id;
	
	public SecondComment() {
		// TODO Auto-generated constructor stub
	}
	
	public SecondComment(Integer comment_id,Integer second_comment_id) {
		this.comment_id = comment_id;
		this.second_comment_id = second_comment_id;
	}
	
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public Integer getSecond_comment_id() {
		return second_comment_id;
	}
	public void setSecond_comment_id(Integer second_comment_id) {
		this.second_comment_id = second_comment_id;
	}
	
}
