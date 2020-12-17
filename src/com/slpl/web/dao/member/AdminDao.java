package com.slpl.web.dao.member;

import java.util.List;

import com.slpl.web.entity.member.Admin;

public interface AdminDao {
	int insert(Admin admin);  	//권한 추가
	int delete(int id);  	//권한 삭제
	Admin get(int id);
	List<Admin> getList();
}
