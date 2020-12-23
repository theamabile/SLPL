package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.slpl.web.dao.test.TypeDao;
import com.slpl.web.entity.test.Question;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcTypeDao implements TypeDao {

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inset(int testId, String name) {
		 int result = 0;
	     
	      String url = DBContext.URL;
	      String sql = "INSERT INTO TYPE( NAME,TEST_ID) VALUES('"+name+"',"+testId+") RETURNING ID INTO ?"; 
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
	         
//	         id값 반환
	         st.registerReturnParameter(1,Types.INTEGER);
	         
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

}
