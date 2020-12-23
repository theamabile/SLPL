package com.slpl.web.service.test;

import com.slpl.web.dao.jdbc.JdbcAnswerScoreDao;
import com.slpl.web.dao.test.AnswerScoreDao;
import com.slpl.web.entity.test.AnswerScore;

public class AnswerScoreService {
	AnswerScoreDao scoreDao;
	
	public AnswerScoreService() {
		scoreDao = new JdbcAnswerScoreDao();
	}

	public int insert(AnswerScore score) {
		
		return scoreDao.insert(score);
		
	}
	
	

}
