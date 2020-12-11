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

import com.slpl.web.dao.member.MemberDao;
import com.slpl.web.entity.member.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int insert(Member member) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "insert into member(login_id, pw, name, nickname, gender,"
				+ " birthday, phone_number, email, profile_img, category_id)" + 
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, member.getLoginId());
			pst.setString(2, member.getPw());
			pst.setString(3, member.getName());
			pst.setString(4, member.getNickname());
			pst.setString(5, member.getGender());
			pst.setDate(6,  member.getBirthday());
			pst.setString(7, member.getPhoneNumber());
			pst.setString(8, member.getEmail());
			pst.setString(9, member.getProfileImg());
			pst.setInt(10, member.getCategoryId());
			
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
	public int update(Member member) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "update member set pw=?, name=?, nickname=?, gender=?, "
				+ "birthday=?, phone_number=?, email=?, profile_img=?, category_id=? " 
				+ "where id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, member.getPw());
			pst.setString(2, member.getName());
			pst.setString(3, member.getNickname());
			pst.setString(4, member.getGender());
			pst.setDate(5, member.getBirthday());
			pst.setString(6, member.getPhoneNumber());
			pst.setString(7, member.getEmail());
			pst.setString(8, member.getProfileImg());
			pst.setInt(9, member.getCategoryId());
			pst.setInt(10, member.getId());
			
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
		String sql = "delete from member where id=?";
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
	public Member get(int id) {
		Member m = null;	
		
		String url = DBContext.URL;
		String sql = "select * from member where id="+id;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Date regdate = rs.getDate("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");
				
				m = new Member(id, loginId, pw, name, nickname, gender,
						birthday, phoneNumber, email, regdate, profileImg, categoryId);
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
		
		return m;
	}

	@Override
	public List<Member> getList() {
		List<Member> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "select * from member";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Date regdate = rs.getDate("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");
				
				Member m = new Member(id, login_id, pw, name, nickname, gender,
						birthday, phoneNumber, email, regdate, profileImg, categoryId);
				
				list.add(m);
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
		
		return list;
	}

	@Override
	public List<Member> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(int page, String category, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getByNickname(String nickname) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
