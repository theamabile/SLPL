package com.slpl.web.service.test;


import com.slpl.web.dao.jdbc.JdbcCharacterDao;
import com.slpl.web.dao.test.CharacterDao;
import com.slpl.web.entity.test.Character;

public class CharacterService {
	
	CharacterDao characterDao;
	
	public CharacterService() {
		characterDao = new JdbcCharacterDao();
	}

	public int insert(Character character) {

		return characterDao.insert(character);
	}

	public int insertContent(Character character) {
		
		int id = character.getId();
		String content = character.getContent();
		String img = character.getImg();
		if(img != null)
				characterDao.update(id,"IMG",img);
		System.out.println("service   : " +content);
		return characterDao.update(id,"CONTENT",content);
		
	}

	public Character get(int id) {
		
		return characterDao.get(id);
	}

	public Character search(int testId,int no) {
	
		return characterDao.getChar(testId,no);
	}


}
