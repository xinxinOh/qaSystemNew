package entity;

import java.util.Date;

public class Question {
	
	private Integer qestion_id;
	private String u_id;
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
	
	public Question(Integer qestion_id,String u_id ,String title , String content , Integer fever,
				 Integer answer_num , Integer collect_mun,Date question_date ,Integer type) {
		this.qestion_id = qestion_id;
		this.u_id = u_id;
		this.title = title;
		this.content = content;
		this.fever = fever;
		this.answer_num = answer_num;
		this.collect_num = collect_mun;
		this.question_date = question_date;
		this.type = type;
				
	}
	
	
	public Integer getQestion_id() {
		return qestion_id;
	}
	public void setQestion_id(Integer qestion_id) {
		this.qestion_id = qestion_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
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
