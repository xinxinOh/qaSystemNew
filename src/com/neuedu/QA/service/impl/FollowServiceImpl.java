/**
 * 
 */
package com.neuedu.QA.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neuedu.QA.dao.impl.CollectionInfoDaoImpl;
import com.neuedu.QA.dao.impl.UserFollowDaoImpl;
import com.neuedu.QA.entity.Question;
import com.neuedu.QA.entity.UserFollow;
import com.neuedu.QA.service.FollowService;

/**
 * @author lenovo
 *
 */
public class FollowServiceImpl implements FollowService {

	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.FollowService#AddFollow(java.lang.String, int)
	 */
	
	
	private UserFollowDaoImpl userFollowDaoImpl = new UserFollowDaoImpl();
	@Override
	public int AddFollow(String user_id, String to_user_id) {
		
	    int ret = userFollowDaoImpl.AddFollow(user_id, to_user_id);    
		return ret;
		
	}
    
	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.FollowService#ShowFollow(java.lang.String, int, int)
	 */
	
	@Override
	public ArrayList<UserFollow> ShowFollow(String user_id, int start, int end) {
		ResultSet res = userFollowDaoImpl.SelectFollow(user_id,start,end);
		
		ArrayList<UserFollow> userFollows = new ArrayList<UserFollow>();
		try {
			while (res.next()) {
				userFollows.add(new UserFollow(res.getString(1),res.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userFollows;
	}

	
	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.FollowService#DeleteFollow(java.lang.String, int)
	 */
	@Override
	public int DeleteFollow(String user_id, String to_user_id) {
		 int ret = userFollowDaoImpl.DeleteFollow(user_id, to_user_id);		    
	    return ret;
	}

}
