package com.slpl.web.dao.community;

import java.util.List;

import com.slpl.web.entity.community.CommunityNotice;
import com.slpl.web.entity.community.CommunityNoticeView;

public interface CommunityNoticeDao {

	
	int insert(CommunityNotice communityNotice);
	int update(CommunityNotice communityNotice);
	int delete(int id);
	int insertAll(String title, String content, int ids);
	
	List<CommunityNotice> getList();
	//List<CommunityNotice> getList(int page, int[] communityCategoryIds);
	
	List<CommunityNoticeView> getViewList();
	List<CommunityNoticeView> getViewList(int page);
	int getNoticeCount();
	
	
}
