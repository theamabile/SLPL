package com.slpl.web.service.test;

import java.io.Console;
import java.util.List;

import com.slpl.web.dao.jdbc.JdbcTestDao;
import com.slpl.web.dao.test.TestDao;
import com.slpl.web.entity.test.Test;

public class TestService {
	
	private TestDao testDao;
	
	public TestService() {
		testDao = new JdbcTestDao();
	}
	
	public List<Test> getList(int page, int size) {
		int startIndex = 1+(page-1)*size;
		int endIndex = page*size;
		return testDao.getList(startIndex,endIndex);
	}
	
	public List<Test> getList(int page, int size, String field, String query){
		int startIndex = 1+(page-1)*size;
		int endIndex = page*size;
		return testDao.getList(startIndex, endIndex, field, query);		
	};
	
	public List<Test> getList(int page, int size, String field, String query,String align){
		int startIndex = 1+(page-1)*size;
		int endIndex = page*size;
		return testDao.getList(startIndex, endIndex, field, query, align);		
	};
	
	
	 public int regBest(int id) {
		 
	      Test test  = testDao.get(id); 
	      test.setBestState(1);

	      return  testDao.update(test,"BEST_STATE", test.getBestState());
	   }

	 public List<Test> getList(int page, int size, String align) {
		 int startIndex = 1+(page-1)*size;
		 int endIndex = page*size;
		 return testDao.getList(startIndex, endIndex, align);	
	 }
	 public List<Test> getList(int page, int size, String field, String query, String field2, String query2){
		 int startIndex = 1+(page-1)*size;
		 int endIndex = page*size;
		 return testDao.getList(startIndex, endIndex, field, query, field2,query2);
		 
	 };
	public List<Test> getList(int page, int size, String field1, String query1, String field2, String query2,String align) {
		int startIndex = 1+(page-1)*size;
		int endIndex = page*size;
		return testDao.getList(startIndex, endIndex, field1, query1,field2, query2, align);	
	}

	public int updateAll(int[] ids, String coulumn, int value) {
		
		int result = 0;
	      for(int i=0; i<ids.length; i++) {
	         int id = ids[i];
	         result += testDao.update(id,coulumn,value);
	         System.out.printf("%s  : %d",coulumn,value);
	      }
	      
	      return result;
		
	}

	public int update(int id, String coulumn, int value) {
		
	      return testDao.update(id,coulumn,value);
	}

	public Test get(int id) {
		// TODO Auto-generated method stub
		return testDao.get(id);
	}

	public int insert(Test t) {
		
		return testDao.insert(t);
	}

	public void update(Test t) {
		testDao.update(t);
		
	}

	public void coverUpdate(int testId, String img) {
		
		Test t = testDao.get(testId);
		t.setCoverImg(img);
		testDao.update(t);
	}

	




	
	
	

}
