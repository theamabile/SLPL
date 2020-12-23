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

import com.slpl.web.dao.community.CommunityNoticeDao;
import com.slpl.web.entity.community.CommunityNotice;
import com.slpl.web.entity.community.CommunityNoticeView;

public class JdbcCommunityNoticeDao implements CommunityNoticeDao{

	@Override
	public int insertAll(String title, String content, int ids) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "INSERT INTO community_notice(id,member_id,title,content,community_category_id) VALUES(SEQ_c_NOTICE.nextval,1,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, title);
			st.setString(2, content);
			st.setInt(3, ids);
			System.out.println(title+content+ids);
			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int update(CommunityNotice communityNotice) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<CommunityNotice> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityNoticeView> getViewList() {
		
		int page = 1;
		//String[] communityCategoryIds = null;
		return getViewList(page);
	}

	

	@Override
	public int delete(int id) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "delete from community_notice where id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			result = st.executeUpdate();
			
//			String sql2 = "delete from community where id = ?";
//			st = con.prepareStatement(sql2);
//			
//			st.setInt(1, id);
//
//			result = st.executeUpdate();

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
	public List<CommunityNoticeView> getViewList(int page) {
		
		
		List<CommunityNoticeView> list = new ArrayList<>();
		String url = DBContext.URL;
		
		String sql = "select * from (select * from (select rownum num,n.* \r\n" + 
				"from (select * from community_notice_view order by regdate desc) n)\r\n" + 
				"where num between ? and ?)m";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			//st.setS
			st.setInt(1, 1+(page-1)*5);
			st.setInt(2, page*5);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				String categoryName = rs.getString("name");
				//int communityCategoryId = rs.getInt("category_id");

				CommunityNoticeView n = new CommunityNoticeView(id,title, content, regDate,categoryName);
				list.add(n);

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
	public int getNoticeCount() {
		int count = 0;
		
		String url = DBContext.URL;
		String sql =  "select count(id) count from (select rownum num,n.* \r\n" + 
				"from (select * from community_notice_view order by regdate desc) n)\r\n";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			count = rs.getInt("count");
			
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

		return count;
	}

	@Override
	public int insert(CommunityNotice communityNotice) {
		// TODO Auto-generated method stub
		return 0;
	}





}
