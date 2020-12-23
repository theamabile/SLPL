package com.slpl.web.dao.community;

import java.util.List;

import com.slpl.web.entity.community.CommentReg;
import com.slpl.web.entity.community.CommentView;
import com.slpl.web.entity.community.CommunityCategory;

public interface CommentRegDao {
	
	int insert(CommentReg commentReg);
	//int delete(int id);
	
	List<CommentView> getComment(int id);

	//CommentReg insert(String comment);


}
