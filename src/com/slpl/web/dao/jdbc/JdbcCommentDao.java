package com.slpl.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.slpl.web.dao.community.CommentRegDao;
import com.slpl.web.entity.community.CommentReg;
import com.slpl.web.entity.community.CommentView;
import com.slpl.web.entity.community.CommunityView;

public class JdbcCommentDao implements CommentRegDao{

	@Override
	public int insert(CommentReg commentReg) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "INSERT INTO comment_reg(id,community_id,member_id, content) VALUES(SEQ_comment_reg.nextval,?,6,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, commentReg.getCommunityId());
			st.setString(2, commentReg.getContent());
			
			
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
	
	

	@Override
	public List<CommentView> getComment(int id) {
		List<CommentView> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql = "select c.*, m.nickname from comment_reg c left join member m on c.member_id = m.id where c.community_id = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			//st.setS
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				id = rs.getInt("id");
				int communityId = rs.getInt("community_id");
				int memberId = rs.getInt("member_id");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("regdate");
				String memberNick = rs.getString("nickname");
				
				CommentView n = new CommentView(
						id,communityId,memberId, content,
						regDate,memberNick);
				System.out.println(n);
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
}

//	@Override
//	public CommentReg insert(String comment) {
//		
//	
//
//}
