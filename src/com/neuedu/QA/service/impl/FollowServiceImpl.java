/**
 * 
 */
package com.neuedu.QA.service.impl;

import java.util.ArrayList;

import com.neuedu.QA.dao.impl.CollectionInfoDaoImpl;
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
	
	private CollectionInfoDaoImpl collectionInfoDaoImpl = new CollectionInfoDaoImpl();
	@Override
	public int AddFollow(String user_id, int to_user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.FollowService#ShowFollow(java.lang.String, int, int)
	 */
	@Override
	public ArrayList<UserFollow> ShowFollow(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neuedu.QA.service.FollowService#DeleteFollow(java.lang.String, int)
	 */
	@Override
	public int DeleteFollow(String user_id, int to_user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
