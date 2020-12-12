package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Question;

public interface AnswerDao {
	int insert(Question question);
	int update(Question question);
	int delete(int id);
	
	List<Question> getList();
}
