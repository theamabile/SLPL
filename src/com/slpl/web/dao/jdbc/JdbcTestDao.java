package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.test.TestDao;
import com.slpl.web.entity.test.Test;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcTestDao implements TestDao {

	@Override
	public int insert(Test test) {
	      int result = 0;
	     
	      String url = DBContext.URL;
	      String sql = "INSERT INTO TEST(MEMBER_ID, NAME,PUBLIC_STATE,FORM_LEVEL_ID) VALUES(?,?,?,?) RETURNING ID INTO ?"; 
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
	         st.setInt(1, test.getMemberId());
	         st.setString(2, test.getName());         
	         st.setInt(3,test.getPublicState());
	         st.setInt(4,test.getFormLevelId());
//	         id값 반환
	         st.registerReturnParameter(5,Types.INTEGER);
	         
	         st.execute();
	         ResultSet rs = st.getReturnResultSet();
	         rs.next();
	         result = rs.getInt(1);
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
	public int delete(int id) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "DELETE FROM TEST WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			result = st.executeUpdate(); // insert, update, delete 문장일 때
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
	public int update(Test test, String coulumn, int value) {
		int id = test.getId();
		return update(id, coulumn, value);

	}

	@Override
	public int update(int id, String coulumn, int value) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "UPDATE TEST SET " + coulumn + "=" + value + " WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			result = st.executeUpdate(); // insert, update, delete 문장일 때
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
	public Test get(int id) {
		Test t = null;
		String url = DBContext.URL;
		String sql = "SELECT * FROM TEST WHERE ID =" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next())
				try {
					String name = rs.getString("NAME");
					int memberId = rs.getInt("MEMBER_ID");
					String coverImg = rs.getString("COVER_IMG");
					int publicState = rs.getInt("PUBLIC_STATE");
					int bestState = rs.getInt("BEST_STATE");
					int shareCnt = rs.getInt("SHARE_CNT");
					int hitCnt = rs.getInt("HIT_CNT");
					int recommendCnt = rs.getInt("RECOMMEND_CNT");
					int reportCnt = rs.getInt("REPORT_CNT");
					Timestamp regDate = rs.getTimestamp("REGDATE");
					int formLevelId = rs.getInt("FORM_LEVEL_ID");

					t = new Test(id, name, memberId, coverImg, publicState, bestState, shareCnt, hitCnt, recommendCnt,
							reportCnt, regDate, formLevelId);
					rs.close();
					st.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	@Override
	public List<Test> getList() {
		String url = DBContext.URL;
		String sql = "SELECT *FROM TEST";

		List<Test> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int memberId = rs.getInt("MEMBER_ID");
				String coverImg = rs.getString("COVER_IMG");
				int publicState = rs.getInt("PUBLIC_STATE");
				int bestState = rs.getInt("BEST_STATE");
				int shareCnt = rs.getInt("SHARE_CNT");
				int hitCnt = rs.getInt("HIT_CNT");
				int recommendCnt = rs.getInt("RECOMMEND_CNT");
				int reportCnt = rs.getInt("REPORT_CNT");
				Timestamp regDate = rs.getTimestamp("REGDATE");
				int formLevelId = rs.getInt("FORM_LEVEL_ID");

				Test t = new Test(id, name, memberId, coverImg, publicState, bestState, shareCnt, hitCnt, recommendCnt,
						reportCnt, regDate, formLevelId);
				list.add(t);
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
	public List<Test> getList(int startIndex, int endIndex) {
		String align = "REGDATE";
		return getList(startIndex, endIndex, align);

	}

	@Override
	public List<Test> getList(int startIndex, int endIndex, String align) {

		return getList(startIndex, endIndex, null, null, align);
	}

	@Override
	public List<Test> getList(int startIndex, int endIndex, String field, String query) {

		return getList(startIndex, endIndex, field, query, "REGDATE");

	}

	@Override
	public List<Test> getList(int startIndex, int endIndex, String field, String query, String align) {

		return getList(startIndex, endIndex, field, query, null, null, align, "DESC");
	}

	@Override
	public List<Test> getList(int startIndex, int endIndex, String field, String query, String field2, String query2) {
		return getList(startIndex, endIndex, field, query, field2, query2, "REGDATE", "DESC");
	}

	@Override
	public List<Test> getList(int startIndex, int endIndex, String field1, String query1, String field2, String query2,
			String align) {

		return getList(startIndex, endIndex, field1, query1, field2, query2, align, "DESC");

	}

	@Override
	public List<Test> getList(int startIndex, int endIndex, String field1, String query1, String field2, String query2,
			String align, String order) {
		String url = DBContext.URL;

		String whereSql = " WHERE " + field1 + "= ? ";
		String whereSql2 = " AND " + field2 + "= ? ";

		if (align == null || align.equals(""))
			align = "REGDATE";
		if (field1 == null || query1 == null || query1.equals("")) {
			whereSql = " ";
			whereSql2 = "";
		} else if (field2 == null || query2 == null || query2.equals(""))
			whereSql2 = "";

		String orderBySql = " ORDER BY " + align + " " + order;
		String sql = "SELECT * FROM (" + "SELECT ROWNUM NUM, L.* FROM (" + "SELECT T.* FROM TEST T" + whereSql
				+ whereSql2 + orderBySql + ") L" + ") WHERE NUM BETWEEN ? AND ?";

		List<Test> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			if (field1 == null || query1 == null || query1.equals("")) {
				st.setInt(1, startIndex);
				st.setInt(2, endIndex);
			} else if (field2 == null || query2 == null || query2.equals("")) {
				System.out.println(sql);
				st.setString(1, query1);
				st.setInt(2, startIndex);
				st.setInt(3, endIndex);
			} else {
				System.out.println(sql);
				st.setString(1, query1);
				st.setString(2, query2);
				st.setInt(3, startIndex);
				st.setInt(4, endIndex);
			}
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int memberId = rs.getInt("MEMBER_ID");
				String coverImg = rs.getString("COVER_IMG");
				int publicState = rs.getInt("PUBLIC_STATE");
				int bestState = rs.getInt("BEST_STATE");
				int shareCnt = rs.getInt("SHARE_CNT");
				int hitCnt = rs.getInt("HIT_CNT");
				int recommendCnt = rs.getInt("RECOMMEND_CNT");
				int reportCnt = rs.getInt("REPORT_CNT");
				Timestamp regDate = rs.getTimestamp("REGDATE");
				int formLevelId = rs.getInt("FORM_LEVEL_ID");

				Test t = new Test(id, name, memberId, coverImg, publicState, bestState, shareCnt, hitCnt, recommendCnt,
						reportCnt, regDate, formLevelId);
				list.add(t);
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
	public Test update(Test t) {
		
		   int result = 0;
		String url = DBContext.URL;
		String sql = "UPDATE TEST SET NAME=?,COVER_IMG=?,PUBLIC_STATE=?,BEST_STATE=? WHERE ID=?" ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

		         st.setString(1, t.getName());
		         st.setString(2, t.getCoverImg());      
		         st.setInt(3, t.getPublicState());
		         st.setInt(4, t.getBestState());      
		         st.setInt(5, t.getId());
		         
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
//			
			

		return t;
	}

}