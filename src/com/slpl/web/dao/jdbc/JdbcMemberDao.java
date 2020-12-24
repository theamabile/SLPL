package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.member.MemberDao;
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int insert(Member member) {    //O
		int result = 0;
		String url = DBContext.URL;
		String sql = "insert into member(id, login_id, pw, name, nickname, gender,"
				+ " birthday, phone_number, email, profile_img, category_id)" + 
				"values(member_id_seq.NEXTVAL, ?, ?, ?, ?, ?,"
				+ " ?, ?, ?, ?, ?) RETURNING ID INTO ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
//			PreparedStatement pst = con.prepareStatement(sql);
//			result = pst.executeUpdate();
			OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
			 
			st.setString(1, member.getLoginId());
			st.setString(2, member.getPw());
			st.setString(3, member.getName());
			st.setString(4, member.getNickname());
			st.setString(5, member.getGender());
			st.setDate(6,  member.getBirthday());
			st.setString(7, member.getPhoneNumber());
			st.setString(8, member.getEmail());
			st.setString(9, member.getProfileImg());
			st.setInt(10, member.getCategoryId());
			st.registerReturnParameter(11, Types.INTEGER);
			
			st.execute();  // 실행
			
	        ResultSet rs = st.getReturnResultSet(); // 결과 값 받아오긴
	        rs.next();
	        result = rs.getInt(1);
	        System.out.println("result : " + result);

	         
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
	public Member get(int id) {    // O
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
				Timestamp regdate = rs.getTimestamp("regdate");
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
		return getList(null, null);
	}

	@Override
	public List<Member> getList(String field, String query) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from member ");
		if(field != null && query != null) {
			sb.append(" where "+field+" = '"+query+"' ");
		}
		sb.append(" order by regdate desc ");

		List<Member> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = sb.toString();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Timestamp regdate = rs.getTimestamp("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");

				Member m = new Member(id, loginId, pw, name, nickname, gender,
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

	
	// ========================================= View ==============================================

	public MemberView getView(int id) {    
		MemberView m = null;
		
		String url = DBContext.URL;
		String sql = "select * from member_community_category_view where id="+id;
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
				Timestamp regdate = rs.getTimestamp("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");
				String authority = rs.getString("authority");
				
				m = new MemberView(id, loginId, pw, name, nickname, gender,
						birthday, phoneNumber, email, regdate, profileImg, categoryId, categoryName, authority);
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
	public MemberView getView(String loginId) {
		MemberView m = null;	
		
		String url = DBContext.URL;
		String sql = "select * from member_community_category_view where login_id=? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Timestamp regdate = rs.getTimestamp("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");
				String authority = rs.getString("authority");

				m = new MemberView(id, loginId, pw, name, nickname, gender,
						birthday, phoneNumber, email, regdate, profileImg, categoryId, categoryName, authority);
			}
			
			rs.close();
			pst.close();
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
	public List<MemberView> getViewList() {   
		// TODO Auto-generated method stub 
		List<MemberView> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "select * from member_community_category_view order by regdate desc ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Timestamp regdate = rs.getTimestamp("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");
				String authority = rs.getString("authority");
				
				MemberView m = new MemberView(id, loginId, pw, name, nickname, gender,
						birthday, phoneNumber, email, regdate, profileImg, categoryId, categoryName, authority);
				
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
	public List<MemberView> getViewList(int startIndex, int endIndex, String field, String query) {  // O
		
		// 동적 쿼리 만들기
		String url = DBContext.URL;
		StringBuilder sb = new StringBuilder();
		sb.append("select * " + 
				  "from ( select rownum num, m.* " + 
						 "from ( select * from MEMBER_COMMUNITY_CATEGORY_VIEW ");
						
		if(field != null && query != null) {
			sb.append(" 	where REGEXP_LIKE("+field+", '.*"+query+".*') ");
		}

		sb.append(" order by regdate desc"+
	              " ) m " +
	              " )where num between ? and ?");
		

		String sql = sb.toString();
		
		List<MemberView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
		
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Timestamp regdate = rs.getTimestamp("regdate");
				String profileImg = rs.getString("profile_img");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");
				String authority = rs.getString("authority");
				
				MemberView m = new MemberView(id, loginId, pw, name, nickname, gender,
						birthday, phoneNumber, email, regdate, profileImg, categoryId, categoryName, authority);
				
				list.add(m);
			}
			
			rs.close();
			pst.close();
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
	
	// ---------------------------------------------------------------------------
	
	@Override
	public Member getLast() {    //O
		Member m = null;	
		
		String url = DBContext.URL;
		String sql = "select * from member where id = (select max(id) from member)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			if(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("pw");		
				String gender = rs.getString("gender");
				Date birthday = rs.getDate("birthday");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				Timestamp regdate = rs.getTimestamp("regdate");
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
	
}
