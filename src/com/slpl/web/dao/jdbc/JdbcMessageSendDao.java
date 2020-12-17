package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.slpl.web.dao.member.MessageSendDao;
import com.slpl.web.entity.member.MessageSend;
import com.slpl.web.entity.member.MessageSendView;

public class JdbcMessageSendDao implements MessageSendDao{
	
	@Override
	public int insert(MessageSend ms) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "insert into message_send(id, SENDER_ID, RECEIVER_ID, MESSAGE_ID) " +
					 "values(MESSAGE_SEND_ID_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, ms.getSenderId());
			pst.setInt(2, ms.getReceiverId());
			pst.setInt(3, ms.getMessageId());
			
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
	public MessageSend get(int id) {
		String url = DBContext.URL;
		String sql = "select * from message_send where id=?";
		
		MessageSend m = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int senderId = rs.getInt("sender_id");
				int receiverId = rs.getInt("receiver_id");
				int messageId = rs.getInt("message_id");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				m = new MessageSend(id, senderId, receiverId, messageId, regdate);
			}
			
			rs.close();
			pst.close();
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
	public List<MessageSend> getList() {
		String url = DBContext.URL;
		String sql = "select * from message_send order by regdate desc ";
		
		List<MessageSend> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				int senderId = rs.getInt("sender_id");
				int receiverId = rs.getInt("receiver_id");
				int messageId = rs.getInt("message_id");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				MessageSend m = new MessageSend(id, senderId, receiverId, messageId, regdate);
				list.add(m);
			}
			
			rs.close();
			pst.close();
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
	

	// ============================================== View ========================================================

	@Override
	public MessageSendView getView(int id) {
		String url = DBContext.URL;
		String sql = "select * from MESSAGE_SEND_MEMBER_VIEW where id=?";
		
		MessageSendView m = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int senderId = rs.getInt("sender_id");
				int receiverId = rs.getInt("receiver_id");
				int messageId = rs.getInt("message_id");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				String senderName = rs.getString("sender_name");
				String receiverName = rs.getString("receiver_name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String type = rs.getString("type");
				
				m = new MessageSendView(id, senderId, receiverId, messageId, regdate, 
						senderName, receiverName, title, content, type);
			}
			
			rs.close();
			pst.close();
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
	public List<MessageSendView> getViewList() {
		String url = DBContext.URL;
		String sql = "select * from MESSAGE_SEND_MEMBER_VIEW order by regdate desc ";
		
		List<MessageSendView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				int senderId = rs.getInt("sender_id");
				int receiverId = rs.getInt("receiver_id");
				int messageId = rs.getInt("message_id");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				String senderName = rs.getString("sender_name");
				String receiverName = rs.getString("receiver_name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String type = rs.getString("type");
				
				MessageSendView m = new MessageSendView(id, senderId, receiverId, messageId, regdate, 
						senderName, receiverName, title, content, type);
				list.add(m);
			}
			
			rs.close();
			pst.close();
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
	public List<MessageSendView> getViewList(boolean isSender, int memberId, int startIndex, int endIndex, String field, String query) {
		
		// 동적 쿼리 만들기
		String url = DBContext.URL;
		StringBuilder sb = new StringBuilder();
		sb.append("select * "+
				"from ( select rownum num, m.* "+
			      	  "from ( select * from MESSAGE_SEND_MEMBER_VIEW ");
		
		if(isSender == true) {
			sb.append("where sender_id = ? ");
		} else {
			sb.append("where receiver_id = ? ");
		}
		
		if(field != null && query != null) {
			sb.append( "      and REGEXP_LIKE("+field+", '.*"+query+".*') ");
		}
		
		sb.append( "order by regdate desc"+
	              ") m " +
	              ")where num between ? and ?");
		
		String sql = sb.toString();
		
		List<MessageSendView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);		
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, memberId);
			pst.setInt(2, startIndex);
			pst.setInt(3, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				int senderId = rs.getInt("sender_id");
				int receiverId = rs.getInt("receiver_id");
				int messageId = rs.getInt("message_id");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				String senderName = rs.getString("sender_name");
				String receiverName = rs.getString("receiver_name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String type = rs.getString("type");
				
				MessageSendView m = new MessageSendView(id, senderId, receiverId, messageId, regdate, 
						senderName, receiverName, title, content, type);
				list.add(m);
			}
			
			rs.close();
			pst.close();
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

}
