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

import com.slpl.web.dao.community.CommunityReportDao;
import com.slpl.web.entity.community.CommunityReport;
import com.slpl.web.entity.community.CommunityReportView;

public class JdbcCommunityReportDao implements CommunityReportDao{
	
	
	@Override
	public List<CommunityReport> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "delete from community where id = ?";
		System.out.println(id);

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
	public List<CommunityReport> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityReportView> getViewList() {
	
		int page = 1;
		return getViewList(page);
	}

	@Override
	public List<CommunityReportView> getViewList(int page) {

		List<CommunityReportView> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql = "select * from (select * from (select rownum num,n.* \r\n" + 
				"from (select * from community_report_view order by regdate desc) n)\r\n" + 
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

				int id = rs.getInt("num");
				String badMember = rs.getString("bad_member");
				int communityId = rs.getInt("community_id");
				int categoryId = rs.getInt("category_id");
				String title = rs.getString("title");
				String reason = rs.getString("reason");
				Date regDate = rs.getDate("regdate");
				String reportMember = rs.getString("report_member");

				CommunityReportView n = new CommunityReportView(id,badMember,communityId, categoryId,
						title, reason, regDate,reportMember);
				System.out.println(n);
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
	public int getReportCount() {
		int count = 0;
		
		String url = DBContext.URL;
		String sql =  "select count(community_id) count from (select rownum num,n.* \r\n" + 
				"from (select * from community_report_view order by regdate desc) n)\r\n";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			count = rs.getInt("count");
			
			System.out.println(count);
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
	public int insert(CommunityReport communityReport) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "INSERT INTO community_report(id,member_id,REPORT_CATEGORY_ID,COMMUNITY_ID) VALUES(SEQ_report_reg.nextval,3,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, communityReport.getreportCategoryId());
			st.setInt(2, communityReport.getCommunityId());
			System.out.println("++++++++++++++++++++++"+communityReport.getreportCategoryId() + communityReport.getCommunityId());

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


}
