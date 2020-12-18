package com.slpl.web.service.test;

import com.slpl.web.dao.jdbc.JdbcMemberTestAvgViewDao;
import com.slpl.web.dao.test.MemberTestAvgViewDao;
import com.slpl.web.entity.test.MemberTestAvgView;

public class TestAvgService {
	private MemberTestAvgViewDao testAvgDao;
	
	public TestAvgService() {
		testAvgDao = new JdbcMemberTestAvgViewDao();
	}

	public MemberTestAvgView get(int memberId) {

		
		return testAvgDao.get(memberId);
	}

}
