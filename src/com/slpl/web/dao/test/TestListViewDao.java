package com.slpl.web.dao.test;

import java.util.List;

import com.slpl.web.entity.test.Test;
import com.slpl.web.entity.test.TestListView;

public interface TestListViewDao {
   
   List<TestListView> getList(int startIndex, int endIndex, String field, String query, String align, String order);

}