package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import data.dto.ReviewDto;
import mysql.DbConnect;

public class ReviewDao {

	DbConnect db = new DbConnect();
	
	//shop_num���� �޾Ƽ� �ش� �������� ���䰳�� ���
	public int getTotalCount(String shop_num) {
			
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		String sql="select count(*) from review where shop_num=?";
		int n=0;
			
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				n=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
			
		return n;
			
	}
	
	//���������� �ʿ��� ��ŭ�� �����ϱ�(��ü���)
		public Vector<ReviewDto> getList(int start, int perpage){
			
			Vector<ReviewDto> list = new Vector<ReviewDto>();
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from review order by num desc limit ?,?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				//���ε�
				pstmt.setInt(1, start);
				pstmt.setInt(2, perpage);
				//����
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					
					ReviewDto dto = new ReviewDto();
					
					dto.setNum(rs.getString("num"));
					dto.setShop_num(rs.getString("shop_num"));
					dto.setLogin_num(rs.getString("login_num"));
					dto.setScore(rs.getString("score"));
					dto.setContent(rs.getString("content"));
					dto.setWriter(rs.getString("writer"));
					dto.setPhoto(rs.getString("photo"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					
					list.add(dto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			
			return list;
			
		}
	
}
