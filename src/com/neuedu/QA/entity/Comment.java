package com.neuedu.QA.entity;

import java.util.Date;

public class Comment {
	private Integer comment_id;
	private Integer answer_id;
	private String user_id;
	private String content;
	private Date comment_date;
	private Integer upvote_num;
	private Integer downvote_num;
	public Comment(Integer comment_id, Integer answer_id,String user_id, String content, Date comment_date, Integer upvote_num,
			Integer downvote_num) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.answer_id = answer_id;
		this.content = content;
		this.comment_date = comment_date;
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
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
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
