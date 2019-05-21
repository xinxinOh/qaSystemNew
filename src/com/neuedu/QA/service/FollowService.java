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
	public int AddFollow(int user_id,int to_user_id);
	public ArrayList<UserFollow>  ShowFollow(int user_id,int start,int end);
    public int DeleteFollow(int user_id,int to_user_id);
	
}
