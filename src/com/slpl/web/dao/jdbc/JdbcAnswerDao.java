package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.test.AnswerDao;
import com.slpl.web.entity.test.Answer;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcAnswerDao implements AnswerDao {

	@Override
	public int insert(Answer answer) {
		int result = 0;
	     
	      String url = DBContext.URL;
	      String sql = "INSERT INTO ANSWER(NO,QUESTION_ID,\"CONTENT\") VALUES(?,?,?) RETURNING ID INTO ?"; 
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
	         st.setInt(1, answer.getNo());
	         st.setInt(2, answer.getQuestion_id());         
	         st.setString(3,answer.getContent());
//	         id값 반환
	         st.registerReturnParameter(4,Types.INTEGER);
	         
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
	public int update(int id, String coulumn, int value) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "UPDATE ANSWER SET ?=? WHERE ID=?";

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
		String sql = "DELETE FROM ANSWER WHERE ID=" + id;

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
	public List<Answer> getList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM ANSWER";

		List<Answer> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			try {
				int id = rs.getInt("ID");
				int no = rs.getInt("NO");
				String content = rs.getString("CONTENT");
				int questionId = rs.getInt("QUESTION_ID");

				Answer q = new Answer(id, no, content, questionId);
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
	public Answer get(int id) {
		Answer q = null;
		String url = DBContext.URL;
		String sql = "SELECT * FROM ANSWER WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs;
			rs = st.executeQuery();

			try {

				int no = rs.getInt("NO");
				String content = rs.getString("CONTENT");
				int questionId = rs.getInt("QUESTION_ID");

				q = new Answer(id, no, content, questionId);
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