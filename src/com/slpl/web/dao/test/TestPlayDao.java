package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.TestPlayView;

public interface TestPlayDao {
	
	//기본
	int insert(TestPlayView testPlayView);
	int delete(int id);
	int update(TestPlayView testPlayView);

	TestPlayView get(int id);
	//-------------------------------
	
	//기본 플레이 페이지 리스트
	//pt: pageType(play,result), ct: contentType(start,content), qt: questionType, qtId: questionTypeId
	List<TestPlayView> getList(int id, String ct, String qt, int qtId );

}
