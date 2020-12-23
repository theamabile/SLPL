package com.slpl.web.service.test;

import com.slpl.web.dao.jdbc.JdbcTypeDao;
import com.slpl.web.dao.test.TypeDao;

public class TypeService {
	TypeDao typeDao ;
	public TypeService() {
		typeDao = new JdbcTypeDao();
	}
	
	
	public int insert(int testId, String name) {
		return typeDao.inset(testId,name);
		
		
		
	}

}
