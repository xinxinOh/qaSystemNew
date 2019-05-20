/**
 * 
 */
package com.neuedu.QA.entity;

import java.util.Date;

/**
 * @author lenovo
 *
 */

public class UserInfo {
    	private  String  user_id;
    	private  String  password;
    	private  String  nickname;
    	private  Date  birthdate;
    	private  String  sex;
    	private  Integer  age;
    	private  String  introduction;
    	  	
    	
    	/**132
		 * @param u_id
		 * @param password
		 * @param nickname
		 * @param introduction
		 */
    	
    	
    	public UserInfo() {}
    	
		public UserInfo(String user_id, String password, String nickname, String introduction) {
			this.user_id = user_id;
			this.password = password;
			this.nickname = nickname;
			this.birthdate = birthdate;
			this.sex = sex;
			this.age = age;
			this.introduction = introduction;
		}
		//get銆乻et鏂规硶
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		
		public Date getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
	
}
