package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.AnswerScore;

public interface AnswerScoreDao {
	int insert(AnswerScore answerScore);
	int update(int id, String coulumn, int value);
	int delete(int id);
	
	AnswerScore get(int id);
	List<AnswerScore> getList();
}
