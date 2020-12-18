package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.test.QuestionDao;
import com.slpl.web.entity.test.Question;

public class JdbcQuestionDao implements QuestionDao {

	@Override
	public int insert(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, String coulumn, int value) {
		int result = 0;

	      String url = DBContext.URL;
	      String sql = "UPDATE QUESTION SET ?=? WHERE ID=?";

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, coulumn);
	         st.setInt(2, value);
	         st.setInt(3, id);

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
	public int delete(int id) {
		int result = 0;

	      String url = DBContext.URL;
	      String sql = "DELETE FROM QEUSTION WHERE ID=" + id;

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
	public List<Question> getList() {
	      String url = DBContext.URL;
	      String sql = "SELECT * FROM QUESTION";
	      
	      List<Question> list = new ArrayList<>();

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql);

	         try {
	        	 int id = rs.getInt("ID");
	            int no = rs.getInt("NO");
	            int testId = rs.getInt("TEST_ID");
	            String img = rs.getString("IMG");
	            String content = rs.getString("CONTENT");


	            Question q = new Question( id,  no,  testId,  img,  content);
	            list.add(q);
	            
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

	      return list;
	}

	@Override
	public Question get(int id) {
		Question q = null;
	      String url = DBContext.URL;
	      String sql = "SELECT * FROM QUESTION WHERE ID = ?";

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setInt(1, id);

	         ResultSet rs;
	         rs = st.executeQuery();

	         try {
	            int no = rs.getInt("NO");
	            int testId = rs.getInt("TEST_ID");
	            String img = rs.getString("IMG");
	            String content = rs.getString("CONTENT");


	            q = new Question( id,  no,  testId,  img,  content);
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

	      return q;
	}



}