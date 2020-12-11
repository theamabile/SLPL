package com.slpl.web.dao;

import java.util.List;

public interface TestResultDao {
	int insert(TestResultDao testResultDao);
	int update(TestResultDao testResultDao);
	int delete(int id);
	
	TestResultDao get(int id);
	List<TestResultDao> getList();
}
