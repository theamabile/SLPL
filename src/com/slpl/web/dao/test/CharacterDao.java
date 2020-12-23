package com.slpl.web.dao.test;

import java.util.List;
import com.slpl.web.entity.test.Character;

public interface CharacterDao {
	
	int insert(Character character);
	int update(Character character);
	int delete(int id);
	
	Character get(int id);
	List<Character> getList();
	int update(int id, String coulumn, String content);
	Character getChar(int testId,int no);
	
}
