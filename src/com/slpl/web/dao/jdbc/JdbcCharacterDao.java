package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import com.slpl.web.dao.test.CharacterDao;
import com.slpl.web.entity.test.Character;
import com.slpl.web.entity.test.Test;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcCharacterDao implements CharacterDao {

	@Override
	public int insert(Character character) {
		int result = 0;
	     
	      String url = DBContext.URL;
	      String sql = "INSERT INTO CHARACTER(IMG,NAME,CONTENT,TEST_ID) VALUES(?,?,?,?) RETURNING ID INTO ?"; 
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
	         st.setString(1, character.getImg());
	         st.setString(2, character.getName());         
	         st.setString(3,character.getContent());
	         st.setInt(4,character.getTestId());

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
	public int update(Character character) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Character get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Character> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, String coulumn, String content) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "UPDATE CHARACTER SET " + coulumn + "= '"+content+"' WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println("Dao   : " +content);
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
		return result;
	}

	@Override
	public Character getChar(int testId, int no) {
		Character c = null;
		String url = DBContext.URL;
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, C.* FROM CHARACTER C WHERE TEST_ID =" +testId+")WHERE NUM =" + no;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next())
				try {
					int id = rs.getInt("ID");
					String img = rs.getString("IMG");
					String name = rs.getString("NAME");
					String content = rs.getString("CONTENT");
					
					c = new Character(id, img, name,content,testId);
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

		return c;
	}

}
