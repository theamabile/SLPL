package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.member.AdminDao;
import com.slpl.web.entity.member.Admin;
import com.slpl.web.entity.member.Member;

public class JdbcAdminDao implements AdminDao{

	@Override
	public int insert(Admin admin) {   // 권한 주기
		int result = 0;
		String url = DBContext.URL;
		String sql = "insert into admin values(?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, admin.getMemberId());
			
			result = pst.executeUpdate();
		
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int delete(int id) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "delete from admin where member_id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			result = pst.executeUpdate();
			
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public Admin get(int id) {
		Admin a = null;	
		
		String url = DBContext.URL;
		String sql = "select * from admin where member_id="+id;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				int memberId = rs.getInt("member_id");
				a = new Admin(memberId);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public List<Admin> getList() {
		List<Admin> list = new ArrayList<Admin>();
		
		return list;
	}


}
