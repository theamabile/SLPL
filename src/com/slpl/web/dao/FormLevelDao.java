package com.slpl.web.dao;

import java.util.List;

import com.slpl.web.entity.FormLevel;

public interface FormLevelDao {
	
	FormLevel get(int id);
	List<FormLevel> getList();
	
}
