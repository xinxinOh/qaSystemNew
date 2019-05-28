/**
 * 
 */
package com.neuedu.QA.service;

import java.util.ArrayList;

import com.neuedu.QA.entity.Question;

/**
 * @author lenovo
 *
 */
public interface LoadQuestionService {
    public ArrayList<Question> LoadPopularQuestion(int start,int end);    
	public ArrayList<Question> LoadCategoryQuestion(int type,int start,int end);
}
