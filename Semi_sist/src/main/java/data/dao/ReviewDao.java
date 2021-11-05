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
	
	//���������� �ʿ��� ��ŭ�� �����ϱ�(��ü���)_shop_num�� �ش��ϴ� �������� ���丸!
		public Vector<ReviewDto> getList(int start, int perpage, String shop_num){
			
			Vector<ReviewDto> list = new Vector<ReviewDto>();
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from review where shop_num=? order by num desc limit ?,?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				//���ε�
				pstmt.setString(1, shop_num);
				pstmt.setInt(2, start);
				pstmt.setInt(3, perpage);
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
		
		//insert
		public void insertReview(ReviewDto dto) {
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="insert into review(login_num,shop_num,score,content,writer,writeday) values(?,?,?,?,?,now())";
			
			try {
				pstmt=conn.prepareStatement(sql);
				//���ε�
				pstmt.setString(1, dto.getLogin_num());
				pstmt.setString(2, dto.getShop_num());
				pstmt.setString(3, dto.getScore());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getWriter());
				
				//����
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		
		//delete
		public void deleteReview(String num) {
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="delete from review where num=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		//update
		public void updateReview(ReviewDto dto) {
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="update review set score=?,content=? where num=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getScore());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getNum());
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
			
		}
		
		//num���� �޾Ƽ� �Ѱ��� ���� ������ ��������
		public ReviewDto getOneReview(String num) {
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from review where num=?";
			ReviewDto dto = new ReviewDto();
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					
					dto.setNum(rs.getString("num"));
					dto.setShop_num(rs.getString("shop_num"));
					dto.setLogin_num(rs.getString("login_num"));
					dto.setScore(rs.getString("score"));
					dto.setContent(rs.getString("content"));
					dto.setWriter(rs.getString("writer"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return dto;
			
		}
	
}
