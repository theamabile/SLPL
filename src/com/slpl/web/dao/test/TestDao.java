package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Test;

public interface TestDao {
	
	int insert(Test test);
	int update(Test test);
	int delete(int id);
	Test get(int id);
	List<Test> getList();
	
	
	
	List<Test> getList(int page);
	//sortType > 조회수=1 추천수=2 공유수=3
	List<Test> getList(int page ,int memberId,int sortType,int bestState);
	
	int updateAll(int[] ids);



}
