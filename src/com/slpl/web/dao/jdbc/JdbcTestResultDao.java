package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.test.TestResultDao;
import com.slpl.web.entity.test.TestPlayView;
import com.slpl.web.entity.test.TestResultView;

public class JdbcTestResultDao implements TestResultDao {

	@Override
	public int insert(TestResultView testResultView) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TestResultView testResultView) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestResultView get(int id) {
		TestResultView r = null;

		String url = DBContext.URL;
		String sql = "SELECT ROWNUM NUM, TP.T_ID, TP.T_NAME, M.NICKNAME T_MEMBER_NAME, T.REGDATE T_REGDATE, T.HIT_CNT T_HIT_CNT, T.RECOMMEND_CNT T_RECOM_CNT, C.ID C_ID, C.NAME C_NAME, C.IMG C_IMG, C.CONTENT C_CONTENT " + 
				"FROM (    " + 
				"    SELECT *     " + 
				"    FROM (             " + 
				"        SELECT ROWNUM NUM, T.* " + 
				"        FROM TEST_PLAY_VIEW T WHERE T_ID=?         " + 
				"        ) P     " + 
				"    WHERE ROWNUM = 1 ORDER BY A_NUM     ) TP " + 
				"LEFT JOIN CHARACTER C ON C.TEST_ID = TP.T_ID " + 
				"JOIN TEST T ON TP.T_ID = T.ID " + 
				"JOIN MEMBER M ON T.MEMBER_ID = M.ID WHERE ROWNUM = 1";

		// System.out.printf("sql(get):%s", sql);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int tId = rs.getInt("T_ID");
				String tName = rs.getString("T_NAME");
				String tMemberName = rs.getString("T_MEMBER_NAME");
				Date tRegdate = rs.getDate("T_REGDATE");
				int tHitCnt = rs.getInt("T_HIT_CNT");
				int tRecomCnt = rs.getInt("T_RECOM_CNT");
				int cId = rs.getInt("C_ID");
				String cName = rs.getString("C_NAME");
				String cImg = rs.getString("C_IMG");
				String cContent = rs.getString("C_CONTENT");

				r = new TestResultView( tId,  tName,  tMemberName,  tRegdate,  tHitCnt,  tRecomCnt,  cId,
						 cName,  cImg,  cContent);
			}
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public List<TestResultView> getList(int id) {
		List<TestResultView> list = new ArrayList<>();

		String whereSql = "WHERE ROWNUM = 1";
		
		String url = DBContext.URL;
		String sql = "SELECT ROWNUM NUM, TP.T_ID, TP.T_NAME, M.NICKNAME T_MEMBER_NAME, T.REGDATE T_REGDATE, T.HIT_CNT T_HIT_CNT, T.RECOMMEND_CNT T_RECOM_CNT, "
				+ "C.ID C_ID, C.NAME C_NAME, C.IMG C_IMG, C.CONTENT C_CONTENT " + 
				"FROM (" + 
				"    SELECT * " + 
				"    FROM (     " + 
				"        SELECT ROWNUM NUM, T.* FROM TEST_PLAY_VIEW T WHERE T_ID=? " + 
				"        ) P " + 
				"    WHERE ROWNUM = 1 ORDER BY A_NUM " + 
				"    ) TP " + 
				"LEFT JOIN CHARACTER C ON C.TEST_ID = TP.T_ID " + 
				"JOIN TEST T ON TP.T_ID = T.ID " + 
				"JOIN MEMBER M ON T.MEMBER_ID = M.ID "+whereSql;
		System.out.printf("sql:%s\n", sql);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int tId = rs.getInt("T_ID");
				String tName = rs.getString("T_NAME");
				String tMemberName = rs.getString("T_MEMBER_NAME");
				Date tRegdate = rs.getDate("T_REGDATE");
				int tHitCnt = rs.getInt("T_HIT_CNT");
				int tRecomCnt = rs.getInt("T_RECOM_CNT");
				int cId = rs.getInt("C_ID");
				String cName = rs.getString("C_NAME");
				String cImg = rs.getString("C_IMG");
				String cContent = rs.getString("C_CONTENT");
				

				TestResultView r = new TestResultView( tId,  tName,  tMemberName,  tRegdate,  tHitCnt,  tRecomCnt,  cId,
						 cName,  cImg,  cContent);

				list.add(r);
			}
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
}
