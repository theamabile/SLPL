package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.test.TestDao;
import com.slpl.web.entity.test.Test;

public class JdbcTestDao implements TestDao {

	@Override
	public int insert(Test test) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Test test) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Test get(int id) {
		return null;
	}

	@Override
	public List<Test> getList() {
		String url = DBContext.URL;
		String sql = "SELECT *FROM TEST";
		
		List<Test> list =new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			

			while (rs.next()) {
				
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String memberId = rs.getString("MEMBER_ID");
				String coverImg = rs.getString("COVER_IMG");
				int publicState = rs.getInt("PUBLIC_STATE");
				int bestState = rs.getInt("BEST_STATE");
				int shareCnt = rs.getInt("SHARE_CNT");
				int hitCnt = rs.getInt("HIT_CNT");
				int recommendCnt = rs.getInt("RECOMMEND_CNT");
				int reportCnt = rs.getInt("REPORT_CNT");
				Timestamp regDate = rs.getTimestamp("REGDATE");
				int formCategory = rs.getInt("FORM_CATEGORY");

				Test t = new Test(
						id,
						name,
						memberId,
						coverImg,
						publicState,
						bestState,
						shareCnt,
						hitCnt,
						recommendCnt,
						reportCnt,
						regDate,
						formCategory
						);
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
	public List<Test> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> getList(int page, int memberId, int sortType, int bestState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAll(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
