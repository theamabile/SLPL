package com.slpl.web.service.community;

import java.util.List;

import com.slpl.web.dao.community.CommentRegDao;
import com.slpl.web.dao.jdbc.JdbcCommentDao;
import com.slpl.web.entity.community.CommentReg;
import com.slpl.web.entity.community.CommentView;

public class CommentRegService {
	
	private CommentRegDao commentRegDao;
	
	public CommentRegService() {
		commentRegDao = new JdbcCommentDao();
	}
	
	public List<CommentView> getComment(int id) {
		return commentRegDao.getComment(id);
	}

//	public CommentReg insert(String comment) {
//		return commentRegDao.insert(comment);
//	}

	public int insert(CommentReg cr) {
		return commentRegDao.insert(cr);
		
	}

}
