package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.slpl.web.dao.test.MemberTestAvgViewDao;
import com.slpl.web.entity.test.MemberTestAvgView;

public class JdbcMemberTestAvgViewDao implements MemberTestAvgViewDao {

	@Override
	public MemberTestAvgView get(int memberId) {
		
		MemberTestAvgView testAvg =null;
		String url = DBContext.URL;
		String sql = "SELECT * FROM MEMBER_TEST_AVGVIEW WHERE MEMBER_ID ="+memberId;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs= st.executeQuery();

			if (rs.next())
			try {
				String memberLoginId = rs.getString("MEMBER_LOGIN_ID");
				int regCnt = rs.getInt("REG_CNT");
				int shereAvg = rs.getInt("SHERE_AVG");
				int hitAvg = rs.getInt("HIT_AVG");
				int recommendAvg = rs.getInt("RECOMMEND_AVG");
				int bestCnt = rs.getInt("BEST_CNT");
				
				testAvg = new MemberTestAvgView(memberId,memberLoginId, regCnt, shereAvg, hitAvg, recommendAvg, bestCnt);
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

		return testAvg;
	}

}
