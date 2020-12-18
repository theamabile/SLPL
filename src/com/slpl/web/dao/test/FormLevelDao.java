package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.FormLevel;

public interface FormLevelDao {
	
	FormLevel get(int id);
	List<FormLevel> getList();
	
}
