package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Test;

public interface TestRecommendDao {
	
//추천,삭제
	int insert(int memberId,int testId);
	int delete(int memberId,int testId);

}
