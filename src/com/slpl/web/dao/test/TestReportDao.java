package com.slpl.web.dao;

import java.util.List;

import com.slpl.web.entity.Test;

public interface TestReportDao {
	
	//신고 
	int insert(int memberId,int testId,String reasen);
	int delete(int memberId,int testId,String reasen);

}
