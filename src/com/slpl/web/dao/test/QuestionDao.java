package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Question;

public interface QuestionDao {
	int insert(Question question);
	int update(int id, String coulumn, int value);
	int delete(int id);
	
	Question get(int id);
	List<Question> getList();
}
