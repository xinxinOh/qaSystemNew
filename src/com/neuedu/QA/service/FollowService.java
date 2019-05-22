/**
 * 
 */
package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.UserFollow;

/**
 * @author lenovo
 *
 */
public interface FollowService {
	
	public int AddFollow(String user_id,String to_user_id);
	public ArrayList<UserFollow>  ShowFollow(String user_id,int start,int end);
    public int DeleteFollow(String user_id,String to_user_id);
	
}
