package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Answer;

public interface AnswerDao {
	int insert(Answer answer);
	int update(int id, String coulumn, int value);
	int delete(int id);
	
	Answer get(int id);
	List<Answer> getList();
}
