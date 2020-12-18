package com.slpl.web.service.community;

import java.util.List;

import com.slpl.web.dao.community.CommunityReportDao;
import com.slpl.web.dao.jdbc.JdbcCommunityReportDao;
import com.slpl.web.entity.community.CommunityReportView;

public class CommunityReportService {
	
	private CommunityReportDao communityReportDao;
	
	public CommunityReportService() {
		communityReportDao = new JdbcCommunityReportDao();
	}

	public List<CommunityReportView> getViewList() {
		int page = 1;
		return communityReportDao.getViewList(page);
	}

	
	public int delete(int id) {
		return communityReportDao.delete(id);
	}
	

	public int deleteAll(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = ids[i];
			result += communityReportDao.delete(id);
		}
		return result;
		
	}

	public List<CommunityReportView> getViewList(int page) {
		return communityReportDao.getViewList(page);
	}

	public int getReportCount() {
		return communityReportDao.getReportCount();
	}


}
