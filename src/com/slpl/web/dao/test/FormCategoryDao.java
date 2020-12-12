package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.FormCategory;

public interface FormCategoryDao {
	
	FormCategory get(int id);
	List<FormCategory> getList();
}
