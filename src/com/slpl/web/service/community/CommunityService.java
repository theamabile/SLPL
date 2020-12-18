package com.slpl.web.service.community;

import java.util.List;

import com.slpl.web.dao.community.CommunityDao;
import com.slpl.web.dao.jdbc.JdbcCommunityDao;
import com.slpl.web.entity.community.Community;
import com.slpl.web.entity.community.CommunityView;

public class CommunityService {
	
	private CommunityDao communityDao;
	
	
	public CommunityService() {
		communityDao = new JdbcCommunityDao();
	}
	
	public List<Community> getList() {
		return communityDao.getList();
	}

	public Community getDetail(int id) {
		return communityDao.get(id);
	}

	public int insert(Community community) {
		
		return communityDao.insert(community);
	}	
	

	public int update(Community community) {
		
		return communityDao.update(community);
	}

	public int delete(int id) {
		
		return communityDao.delete(id);
	}

	public List<CommunityView> getViewList() {
		String field = "title";
		String query = "";
		int page = 1;
		return communityDao.getViewList(field, query,page);
	}
	
	public List<CommunityView> getViewList(int page){
		String field = "title";
		String query = "";
		return communityDao.getViewList(field, query,page);
	}

	public List<CommunityView> getViewList(String field, String query, int page) {
		// TODO Auto-generated method stub
		return communityDao.getViewList(field, query,page);
	}
	
	public int getCommunityCount(String field, String query) {
		return communityDao.getCommunityCount(field, query);
	}
	

//	public int getLastId() {
//		
//		Community c = CommunityDao.getLast();
//		return c.getId();
//	}

}