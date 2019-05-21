/**
 * 
 */
package com.neuedu.QA.dao;

import java.sql.ResultSet;

import com.neuedu.QA.entity.Answer;

/**
 * @author lenovo
 *
 */
public interface AnswerDao {
        public ResultSet SelectAllAnswer(String user_id);
        public ResultSet SelectAnswer(int question_id,int start,int end);
        public Answer SelectOneAnswer(int answer_id);
        public int addAnswer(Answer a);
        public int updateAnswer(Answer a);
        public int deleteAnswer(int Answer_id);
}
