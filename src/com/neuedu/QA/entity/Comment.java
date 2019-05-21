package com.neuedu.QA.entity;

import java.util.Date;

public class Comment {
	private Integer comment_id;
	private Integer answer_id;
	private String user_id;
	private String content;
	private Date disscuss_date;
	private Integer upvote_num;
	private Integer downvote_num;
	public Comment(Integer comment_id, Integer answer_id,String user_id, String content, Date disscuss_date, Integer upvote_num,
			Integer downvote_num) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.answer_id = answer_id;
		this.content = content;
		this.disscuss_date = disscuss_date;
		this.upvote_num = upvote_num;
		this.downvote_num = downvote_num;
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDisscuss_date() {
		return disscuss_date;
	}
	public void setDisscuss_date(Date disscuss_date) {
		this.disscuss_date = disscuss_date;
	}
	public Integer getUpvote_num() {
		return upvote_num;
	}
	public void setUpvote_num(Integer upvote_num) {
		this.upvote_num = upvote_num;
	}
	public Integer getDownvote_num() {
		return downvote_num;
	}
	public void setDownvote_num(Integer downvote_num) {
		this.downvote_num = downvote_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
