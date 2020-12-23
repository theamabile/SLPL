package com.slpl.web.board.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListService {
	public List<Board> getList() {
		List<Board> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "select * from board";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "mbti", "1111");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int boardNo = rs.getInt("board_no");
				String userId = rs.getString("user_id");
				String userNick = rs.getString("user_nick");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int boardTypeId = rs.getInt("board_type_id");
				int hits = rs.getInt("hits");
				int recommend = rs.getInt("recommend");
				Date regDate = rs.getDate("reg_date");

				Board n = new Board(boardNo, userId, userNick, title, content, boardTypeId, hits, recommend, regDate);
				
				list.add(n);
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
	
	public Board getDetail(int id) {
		Board n = null;
	  
	  String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	  String sql ="select * from board where board_id = " + id;
	  
	  try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection(url, "NEWLEC", "11111"); 
		  Statement st =
	  con.createStatement(); ResultSet rs = st.executeQuery(sql);
	  
	  int i = 0; if (rs.next()) {
	  
		  int boardNo = rs.getInt("board_no");
			String userId = rs.getString("user_id");
			String userNick = rs.getString("user_nick");
			String title = rs.getString("title");
			String content = rs.getString("content");
			int boardTypeId = rs.getInt("board_type_id");
			int hits = rs.getInt("hits");
			int recommend = rs.getInt("recommend");
			Date regDate = rs.getDate("reg_date");
	  
			n = new Board(boardNo, userId, userNick, title, content, boardTypeId, hits, recommend, regDate);
	  
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
	  System.out.println(n);
	  return n;
	  
	  
	  }

	public int insert(Board board) {
		int result = 0;
		  String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		  String sql ="INSERT INTO board(TITLE,CONTENT) VALUES(?,?)";
		  
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection con = DriverManager.getConnection(url, "mbti", "1111"); 
			  PreparedStatement st = con.prepareStatement(sql);
		  
			  st.setString(1, board.getTitle());
			  st.setString(2, board.getContent());
			  System.out.println(board.getTitle() + board.getContent());
			  
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
		  System.out.println(result);
		  return result;
	}
		
}