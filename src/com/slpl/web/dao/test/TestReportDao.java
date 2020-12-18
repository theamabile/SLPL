package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Test;

public interface TestReportDao {
	
	//신고 
	int insert(int memberId,int testId,String reasen);
	int delete(int memberId,int testId,String reasen);

}
