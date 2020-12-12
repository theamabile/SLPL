package com.slpl.web.dao;

import java.util.List;

import com.slpl.web.entity.Test;

public interface TestRecommendDao {
	
//추천,삭제
	int insert(int memberId,int testId);
	int delete(int memberId,int testId);

}
