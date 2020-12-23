package com.slpl.web.service.test;

import com.slpl.web.dao.jdbc.JdbcQuestionDao;
import com.slpl.web.dao.test.QuestionDao;
import com.slpl.web.entity.test.Question;

public class QuestionService {
	
	QuestionDao QuestionDao;
	
	public QuestionService() {
		QuestionDao = new JdbcQuestionDao();
		
	}

	public int insert(Question q) {

		return QuestionDao.insert(q);
	}



	
	

}
