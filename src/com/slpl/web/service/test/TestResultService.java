package com.slpl.web.service.test;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcTestResultDao;
import com.slpl.web.dao.test.TestResultDao;
import com.slpl.web.entity.test.TestResultView;

public class TestResultService {
	private TestResultDao testResultDao; 
	
	public TestResultService() {
		testResultDao = new JdbcTestResultDao();
	}

	public List<TestResultView> getList(int id) {
		return testResultDao.getList(id);
	}

	public TestResultView get(int id) {
		return testResultDao.get(id);
	}
}
