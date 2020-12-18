package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.test.TestListViewDao;
import com.slpl.web.entity.test.TestListView;

public class JdbcTestListViewDao implements TestListViewDao {

	@Override
	public List<TestListView> getList(int startIndex, int endIndex, String field, String query, String align,
			String order) {
		System.out.println(startIndex);
		System.out.println(endIndex);
		System.out.println(field);
		System.out.println(query);
		System.out.println(align);
		System.out.println(order);

		List<TestListView> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql;

		if (query == null || query.equals("")) {
			sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (SELECT * FROM TEST_LIST_VIEW ORDER BY " + align + " "
					+ order + ") T ) WHERE NUM BETWEEN ? AND ?";
		} else {
			sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* FROM (SELECT * FROM TEST_LIST_VIEW WHERE " + field
					+ " LIKE ? ORDER BY " + align + " " + order + ") T) WHERE NUM BETWEEN ? AND ?";
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			if (query == null || query.equals("")) {
				st.setInt(1, startIndex);
				st.setInt(2, endIndex);
			} else {
				st.setString(1, query);
				st.setInt(2, startIndex);
				st.setInt(3, endIndex);
			}

			System.out.println(sql);
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
				Timestamp regdate = rs.getTimestamp("REGDATE");
				int formLevelId = rs.getInt("FORM_LEVEL_ID");
				String nickname = rs.getNString("NICKNAME");
				String levName = rs.getNString("LEV_NAME");
				String cateName = rs.getNString("CATE_NAME");

				TestListView t = new TestListView(id, name, memberId, coverImg, publicState, bestState, shareCnt,
						hitCnt, recommendCnt, reportCnt, regdate, formLevelId, nickname, levName, cateName);

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

}
