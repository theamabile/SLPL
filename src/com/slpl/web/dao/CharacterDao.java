package com.slpl.web.dao;

import java.util.List;

public interface CharacterDao {
	
	int insert(Character character);
	int update(Character character);
	int delete(int id);
	
	Character get(int id);
	List<Character> getList();
	
}
