package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.slpl.web.dao.test.TestPlayDao;
import com.slpl.web.entity.test.TestPlayView;

public class JdbcTestPlayDao implements TestPlayDao {

	@Override
	public int insert(TestPlayView testPlayView) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TestPlayView testPlayView) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestPlayView get(int id) {
		TestPlayView r = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM TEST_PLAY_VIEW WHERE T_ID = ?";

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
				String tCoverImg = rs.getString("T_COVER_IMG");
				int formType = rs.getInt("T_FORM_LEVEL_ID");
				int qId = rs.getInt("Q_ID");
				int qNum = rs.getInt("Q_NUM");
				String qContent = rs.getString("Q_CONTENT");
				String qImg = rs.getString("Q_IMG");
				int aId = rs.getInt("A_ID");
				int aNum = rs.getInt("A_NUM");
				String aContent = rs.getString("A_CONTENT");
				int sId = rs.getInt("S_ID");
				int sScore = rs.getInt("S_SCORE");
				int sTypeId = rs.getInt("S_TYPE_ID");
				int tpId = rs.getInt("TP_ID");
				String tpName = rs.getString("TP_NAME");

				r = new TestPlayView(tId, tName, tCoverImg, formType, qId, qNum, qContent, qImg, aId, aNum,
						aContent, sId, sScore, sTypeId, tpId, tpName);
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
	public List<TestPlayView> getList(int id, String ct, String qt, int qtId) {
		List<TestPlayView> list = new ArrayList<>();

		String whereSql = "";
		
		if (ct == "start")
			whereSql = "WHERE ROWNUM = 1";
		if (qt != null && !qt.equals(""))
			whereSql = "WHERE P." + qt + " = " + qtId;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM ( " + "    SELECT ROWNUM NUM, T.* FROM TEST_PLAY_VIEW T WHERE T_ID=? " + "    ) P "
				+ whereSql + " ORDER BY A_ID";
		
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
				String tCoverImg = rs.getString("T_COVER_IMG");
				int formType = rs.getInt("T_FORM_LEVEL_ID");
				int qId = rs.getInt("Q_ID");
				int qNum = rs.getInt("Q_NUM");
				String qContent = rs.getString("Q_CONTENT");
				String qImg = rs.getString("Q_IMG");
				int aId = rs.getInt("A_ID");
				int aNum = rs.getInt("A_NUM");
				String aContent = rs.getString("A_CONTENT");
				int sId = rs.getInt("S_ID");
				int sScore = rs.getInt("S_SCORE");
				int sTypeId = rs.getInt("S_TYPE_ID");
				int tpId = rs.getInt("TP_ID");
				String tpName = rs.getString("TP_NAME");

				TestPlayView r = new TestPlayView(tId, tName, tCoverImg, formType, qId, qNum, qContent, qImg, aId, aNum,
						aContent, sId, sScore, sTypeId, tpId, tpName);

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
