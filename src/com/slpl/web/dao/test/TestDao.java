package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Test;

public interface TestDao {
	
	int insert(Test test);
	int update(Test test,String coulumn,int value);
	int update(int id,String coulumn,int value);
	int delete(int id);
	Test get(int id);
	List<Test> getList();
	
	
	List<Test> getList(int startIndex, int endIndex);

	List<Test> getList(int startIndex, int endIndex, String align);
	List<Test> getList(int startIndex, int endIndex, String field, String query);
	List<Test> getList(int startIndex, int endIndex, String field, String query,String align);
	
	List<Test> getList(int startIndex, int endIndex, String field1, String query1, String field2, String query2);
	List<Test> getList(int startIndex, int endIndex, String field1, String query1, String field2, String query2,String align);
	List<Test> getList(int startIndex, int endIndex, String field1, String query1, String field2, String query2,String align,String order);




}
