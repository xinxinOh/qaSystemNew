/**
 * 
 */
package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.Comment;

/**
 * @author lenovo
 *
 */
public interface CommentDao {
        public ResultSet SelectComment(int answer_id,int start,int end);
        public ResultSet SelectSecondComment(int[] secondComment_id);
        public ResultSet SelectUserComment(String User_id);
        public Comment SelectOneComment(int comment_id);
        public int addComment(Comment d);
        public int updateComment(Comment d);
        public int deleteComment(int Comment_id);
        
        
}
