package com.neuedu.QA.service.impl;

import com.neuedu.QA.dao.impl.UserVoteDaoImpl;
import com.neuedu.QA.entity.UserVote;
import com.neuedu.QA.service.VoteService;

public class VoteServiceImpl implements VoteService{

	//public AnswerDaoImpl answerDaoImpl=new AnswerDaoImpl();
	//public CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
	public UserVoteDaoImpl userVoteDaoImpl=new UserVoteDaoImpl();
	public UserVote userVote=new UserVote();
	
	//���ô�����ʵ����
	/*
	 * @Override public int updateAnswerOrComment(int ID, int type) { // TODO
	 * Auto-generated method stub return 0; }
	 */

	@Override
	public int userVote(String user_id, int id, int type, int category) {//category 0����ش� 1��������  type��0�� 1�� 2ȡ���� 3ȡ����
		UserVote userVote=new UserVote(user_id, id, type, category);
		if(type==0||type==1) {//�Ȼ��� ��������
			int i=userVoteDaoImpl.addVote(userVote);
			return i;
		}
		else if (type==2||type==3) {
			int i=userVoteDaoImpl.deleteVote(userVote);
			return i;
		}
		return 0;
	}

}
