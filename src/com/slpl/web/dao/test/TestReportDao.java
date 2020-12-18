package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.TestReport;

public interface TestReportDao {
	
	//기본
	int insert(TestReport testReport);
	int delete(int id);
	int update(TestReport testReport);
	
	TestReport get(int id);
	TestReport get(int id, String key);
	//-------------------------------
	
	//기본 페이지 리스트
	List<TestReport> getList(int startIndex, int endIndex);
	//검색
	List<TestReport> getList(int startIndex, int endIndex, String key, String keyword);
}
