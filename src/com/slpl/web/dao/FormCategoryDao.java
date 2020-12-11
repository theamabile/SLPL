package com.slpl.web.dao;

import java.util.List;

import com.slpl.web.entity.FormCategory;

public interface FormCategoryDao {
	
	FormCategory get(int id);
	List<FormCategory> getList();
}
