package com.slpl.web.service.community;

import java.util.List;

import com.slpl.web.dao.community.CommunityNoticeDao;
import com.slpl.web.dao.jdbc.JdbcCommunityNoticeDao;
import com.slpl.web.entity.community.CommunityNotice;
import com.slpl.web.entity.community.CommunityNoticeView;

public class CommunityNoticeService {

	private CommunityNoticeDao communityNoticeDao;
	
	public CommunityNoticeService() {
		communityNoticeDao = new JdbcCommunityNoticeDao();
	}

	public List<CommunityNotice> getList(int page, int[] communityCategoryIds) {

		return communityNoticeDao.getList(page, communityCategoryIds);
	}

	public List<CommunityNotice> getList() {
		return communityNoticeDao.getList();
	}

	public List<CommunityNoticeView> getViewList() {
		return communityNoticeDao.getViewList();
	}
	
	public int delete(int id) {
		return communityNoticeDao.delete(id);
		
	}


	public int deleteAll(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = ids[i];
			result += communityNoticeDao.delete(id);
		}
		return result;
		
	}
//
//	public List<CommunityNoticeView> getViewList(int page, String[] ids) {
//		
//		return communityNoticeDao.getViewList(page,ids);
//	}
	//categoryId
	public int insert(CommunityNotice reg) {
		return communityNoticeDao.insert(reg);
		
	}
	
//	public int insertAll(int[] ids) {
//		
//		
//	}

	
	public int update(CommunityNotice update) {
		return communityNoticeDao.insert(update);
		
	}

	public CommunityNotice getList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CommunityNoticeView> getViewList(int page) {
		// TODO Auto-generated method stub
		return communityNoticeDao.getViewList(page);
	}

	public int getNoticeCount() {
		return communityNoticeDao.getNoticeCount();
	}

	public int insertAll(String title, String content, int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = ids[i];
			result += communityNoticeDao.insertAll(title, content, id);
		}
		return result;
		
	}



}
