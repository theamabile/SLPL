package com.slpl.web.dao.community;

import java.util.List;

import com.slpl.web.entity.community.CommunityReport;
import com.slpl.web.entity.community.CommunityReportView;

public interface CommunityReportDao {
	int delete(int id);
	
	List<CommunityReport> getList();
	List<CommunityReport> getList(int page);
	
	List<CommunityReportView> getViewList();
	List<CommunityReportView> getViewList(int page);


	int getReportCount();
	
	

}
