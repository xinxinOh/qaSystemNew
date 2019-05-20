package com.neuedu.QA.entity;

import java.util.Date;

public class Answer {
	private Integer answer_id;
	private Integer question_id;
	private String u_id;
	private String content;
	private Integer upvote_num;
	private Integer downvote_num;
	private Integer comment_num;
	private Date answer_date;
	
	public Answer(Integer answer_id, Integer question_id, String u_id, String content, Integer upvote_num, Integer downvote_num,
			Integer comment_num, Date answer_date) {
		super();
		this.answer_id = answer_id;
		this.question_id = question_id;
		this.u_id = u_id;
		this.content = content;
		this.upvote_num = upvote_num;
		this.downvote_num = downvote_num;
		this.comment_num = comment_num;
		this.answer_date = answer_date;
		
		
		
	}

	public Integer getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Integer getComment_num() {
		return comment_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public Date getAnswer_date() {
		return answer_date;
	}

	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}
	
}
