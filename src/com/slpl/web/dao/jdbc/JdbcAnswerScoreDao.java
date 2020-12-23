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

import com.slpl.web.dao.test.AnswerScoreDao;
import com.slpl.web.entity.test.AnswerScore;

import oracle.jdbc.OraclePreparedStatement;


public class JdbcAnswerScoreDao implements AnswerScoreDao {

	@Override
	public int insert(AnswerScore Score) {
		int result = 0;
	     
	      String url = DBContext.URL;
	      String sql = "INSERT INTO ANSWER_SCORE(ANSWER_ID,SCORE,TYPE_ID) VALUES(?,?,?) RETURNING ID INTO ?"; 
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
	         st.setInt(1, Score.getAnswer_id());
	         st.setInt(2, Score.getScore());         
	         st.setInt(3,Score.getType_id());
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
		String sql = "UPDATE ANSWERSCORE SET ?=? WHERE ID=?";

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
		String sql = "DELETE FROM ANSWERSCORE WHERE ID=" + id;

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
	public List<AnswerScore> getList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM ANSWERSCORE";

		List<AnswerScore> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			try {
				int id = rs.getInt("ID");
				int answerId = rs.getInt("ANSWER_ID");
				int typeId = rs.getInt("TYPE_ID");
				int score = rs.getInt("SCORE");

				AnswerScore a = new AnswerScore(id, answerId, typeId, score);
				list.add(a);

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
	public AnswerScore get(int id) {
		AnswerScore a = null;
		String url = DBContext.URL;
		String sql = "SELECT * FROM ANSWERSCORE WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs;
			rs = st.executeQuery();

			try {
			
				int answerId = rs.getInt("ANSWER_ID");
				int typeId = rs.getInt("TYPE_ID");
				int score = rs.getInt("SCORE");

				a = new AnswerScore(id, answerId, typeId, score);
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

		return a;
	}

}