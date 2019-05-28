package com.neuedu.QA.entity;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable{
	
	private Integer question_id;
	private String user_id;
	private String title;
	private String content;
	private Integer fever;
	private Integer answer_num;
	private Integer collect_num;
	private Date question_date;
	private Integer type;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	public Question(String user_id ,String title , String content ,Date question_date ,Integer type) {
		this.question_id = null;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.fever = 0;
		this.answer_num = 0;
		this.collect_num = 0;
		this.question_date = question_date;
		this.type = type;
				
	}
	
	
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getFever() {
		return fever;
	}
	public void setFever(Integer fever) {
		this.fever = fever;
	}
	public Integer getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(Integer answer_num) {
		this.answer_num = answer_num;
	}
	public Integer getCollect_num() {
		return collect_num;
	}
	public void setCollect_num(Integer collect_num) {
		this.collect_num = collect_num;
	}
	public Date getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(Date question_date) {
		this.question_date = question_date;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
