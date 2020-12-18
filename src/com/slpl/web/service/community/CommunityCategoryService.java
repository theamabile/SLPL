package com.slpl.web.service.community;

import java.util.List;

import com.slpl.web.dao.community.CommunityCategoryDao;
import com.slpl.web.dao.jdbc.JdbcCommunityCategoryDao;
import com.slpl.web.entity.community.CommunityCategory;

public class CommunityCategoryService {

	private CommunityCategoryDao communityCategoryDao;

	public CommunityCategoryService() {
		communityCategoryDao = new JdbcCommunityCategoryDao();
	}

	public List<CommunityCategory> getList() {
		return communityCategoryDao.getList();
	}

	public int insert(CommunityCategory reg) {
		return communityCategoryDao.insert(reg);
	}

	public int delete(int id) {
		return communityCategoryDao.delete(id);
	}

	public int deleteAll(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = ids[i];
			result += communityCategoryDao.delete(id);
		}
		return result;

	}

}
