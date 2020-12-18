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

import com.slpl.web.dao.test.TestDao;
import com.slpl.web.dao.test.TestReportDao;
import com.slpl.web.entity.test.TestReport;

public class JdbcTestReportDao implements TestReportDao {

	@Override
	public int insert(TestReport testReport) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TestReport testReport) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "UPDATE TEST_REPORT SET state = ? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, testReport.getState());
			st.setInt(2, testReport.getId());
			result = st.executeUpdate(); // INSERT, UPDATE, DELETE 문 실행시
			// ResultSet rs = st.executeQuery(sql); //SELECT 문 실행시에만 사용

			st.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestReport get(int id) {
		return get(id, null);
	}

	@Override
	public List<TestReport> getList(int startIndex, int endIndex) {
		return getList(startIndex, endIndex, null, null);

	}

	@Override
	public TestReport get(int id, String key) {
		TestReport r = null;

		String url = DBContext.URL;
		String sql = "SELECT R.*, M.LOGIN_ID MEMBER_NICNAME " + "FROM TEST_REPORT R "
				+ "JOIN MEMBER M ON R.MEMBER_ID = M.ID " + "WHERE R.ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				int testId = rs.getInt("test_id");
				int memberId = rs.getInt("member_id");
				String reason = rs.getString("reason");
				Date regdate = rs.getDate("regdate");
				int type = rs.getInt("type");
				String warringMsgDate = rs.getString("warring_msg_date");
				String state = rs.getString("state");
				String memberNicname = rs.getString("member_nicname");

				r = new TestReport(id, testId, memberId, reason, regdate, type, warringMsgDate, state, memberNicname);

			}
			rs.close();
			st.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<TestReport> getList(int startIndex, int endIndex, String key, String keyword) {
		List<TestReport> list = new ArrayList<>();

		String whereSql = "";
		if (key != null && keyword != null && keyword.equals("") == false) {
			whereSql = "WHERE (  T." + key + " LIKE '%" + keyword + "%') ";
		}

		String url = DBContext.URL;
		String sql = "SELECT * " + 
				"FROM (" + 
				"    SELECT ROWNUM NUM, TR.*    " + 
				"    FROM         " + 
				"        (" + 
				"        SELECT *		" + 
				"        FROM TEST_REPORT T         " + 
				"        LEFT JOIN MEMBER M ON T.MEMBER_ID = M.ID" +  
				" 		 " + whereSql +
				"        ORDER BY T.ID ASC        " + 
				"        ) TR    " + 
				"    ) TM " + 
				"WHERE (NUM BETWEEN ? AND ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, startIndex);
			st.setInt(2, endIndex);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int testId = rs.getInt("test_id");
				int memberId = rs.getInt("member_id");
				String reason = rs.getString("reason");
				Date regdate = rs.getDate("regdate");
				int type = rs.getInt("type");
				String warringMsgDate = rs.getString("warring_msg_date");
				String state = rs.getString("state");

				TestReport r = new TestReport(id, testId, memberId, reason, regdate, type, warringMsgDate, state);

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
