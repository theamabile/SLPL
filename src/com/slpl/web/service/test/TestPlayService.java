package com.slpl.web.service.test;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcTestPlayDao;
import com.slpl.web.dao.test.TestPlayDao;
import com.slpl.web.entity.test.TestPlayView;

public class TestPlayService {
	private TestPlayDao testPlayDao;
	
	public TestPlayService() {
		testPlayDao = new JdbcTestPlayDao();
	}
	
	public TestPlayView get(int id){
		return testPlayDao.get(id);
	}

	public List<TestPlayView> getList(int id, int qId) {
		String questionType = "Q_NUM";
		return testPlayDao.getList(id, "content", questionType, qId );
	}
	
	public List<TestPlayView> getStartList(int id, String pageType) {		
		return testPlayDao.getList(id, "start", null, 0);
	}
}
