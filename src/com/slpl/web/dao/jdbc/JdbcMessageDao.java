package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.member.MessageDao;
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.Message;


public class JdbcMessageDao implements MessageDao{

	@Override
	public int insert(Message message) {
		
		int result = 0;
		String url = DBContext.URL;
		String sql = "insert into message(id, TITLE, CONTENT, TYPE) " +
					 "values(MESSAGE_ID_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, message.getTitle());
			pst.setString(2, message.getContent());
			pst.setString(3, message.getType());
			
			result = pst.executeUpdate();
		
			pst.close();
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
	public Message get(int id) {
		Message m = null;	
		
		String url = DBContext.URL;
		String sql = "select * from message where id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement st = con.prepareStatement(sql);
	        
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String type = rs.getString("type");
				m = new Message(id, title, content, type);
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
		
		return m;
	}

	
	@Override
	public List<Message> getList() {
		List<Message> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "select * from message";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String type = rs.getString("type");
				
				Message m = new Message(id, title, content, type);
				list.add(m);
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
	public Message getLast() {   
		Message m = null;	
		
		String url = DBContext.URL;
		String sql = "select * from message where id = (select max(id) from message)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String type = rs.getString("type");
				m = new Message(id, title, content, type);
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
		
		return m;
	}
	
}
