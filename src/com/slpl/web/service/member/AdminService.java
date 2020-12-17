package com.slpl.web.service.member;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcAdminDao;
import com.slpl.web.dao.member.AdminDao;
import com.slpl.web.entity.member.Admin;

public class AdminService {

	// 여기서 생성자 안만들고 외부로 뺄거임. 내부에 넣으면 결함력 강해짐.
	// 기업용은 보통 외부에 뺌. 완성인지 미완성인지 어떤거 쓸지 모르니까.
	public AdminDao adminDao;
	
	public AdminService() {
		adminDao = new JdbcAdminDao();
	}

	public List<Admin> getList() {
		return adminDao.getList();
	}

	public Admin get(int id) {
		return adminDao.get(id);
	}
	
	public int insert(Admin admin) {
		return adminDao.insert(admin);
	}
	
	public int delete(int id) {
		return adminDao.delete(id);
	}

}
