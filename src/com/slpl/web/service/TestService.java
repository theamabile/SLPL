package com.slpl.web.service;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcTestDao;
import com.slpl.web.dao.test.TestDao;
import com.slpl.web.entity.test.Test;

public class TestService {
	
	private TestDao testDao;
	
	
	public List<Test> getList() {
		return testDao.getList();
	}
	
	

//
//	public List<Test> idSearch(String keyword) {
//		
//		int result =0;
//
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT *FROM POPULTEST WHERE ID='"+keyword+"'";
//		
//		List<Test> list =new ArrayList<>();
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url,"mbti","1111");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			while (rs.next()) {
//					
//					int testNo = rs.getInt("TEST_NO");
//					String title = rs.getString("TITLE");
//					String id = rs.getString("ID");
//					int recommendNum = rs.getInt("RECOMMEMD_NUM");
//					int lookUpNum = rs.getInt("LOOKUP_NUM");
//					int shareNum = rs.getInt("SHARE_NUM");
//					String bestState = rs.getString("BEST_STATE");
//					String publicState = rs.getString("PUBLIC_STATE");;
//					
//	
//					Test t = new Test(
//							testNo,
//							title,
//							id,
//							recommendNum,
//							lookUpNum,
//							shareNum,
//							bestState,
//							publicState
//							);
//					list.add(t);
//			}
//
//			st.close();
//			con.close();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
	
	

}
