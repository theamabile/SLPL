package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.TestResultView;

public interface TestResultDao {
	int insert(TestResultView testResultView);
	int update(TestResultView testResultView);
	int delete(int id);
	
	TestResultView get(int id);
	List<TestResultView> getList(int id);
}
