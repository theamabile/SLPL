package com.slpl.web.service.test;

import com.slpl.web.dao.jdbc.JdbcAnswerDao;
import com.slpl.web.dao.test.AnswerDao;
import com.slpl.web.entity.test.Answer;

public class AnswerService {
	AnswerDao answerDao;
	
	public AnswerService() {
		answerDao = new JdbcAnswerDao();
	}
	public int insert(Answer ans) {

		return answerDao.insert(ans);
		
	}

}
