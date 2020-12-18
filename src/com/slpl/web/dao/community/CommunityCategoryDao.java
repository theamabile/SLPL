package com.slpl.web.dao.community;

import java.util.List;

import com.slpl.web.entity.community.CommunityCategory;

public interface CommunityCategoryDao {

	int insert(CommunityCategory communityCategory);
	int delete(int id);
	
	List<CommunityCategory> getList();
}
