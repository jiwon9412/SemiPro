package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.ShopDto;
import mysql.DbConnect;

public class ShopDao {
	
	DbConnect db = new DbConnect();
	
	//insert
	public void insertShop(ShopDto dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into shop(name,telephone,tag,addr,photo,parking,opening,closing,introduce) values(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTelephone());
			pstmt.setString(3, dto.getTag());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getParking());
			pstmt.setInt(7, dto.getOpening());
			pstmt.setInt(8, dto.getClosing());
			pstmt.setString(9, dto.getIntroduce());
			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	//���� �ֱٿ� �߰��� ��������num �������� _ ���������̺�insert�Ҷ��ʿ�
	public String getRecentNum() {
		
		String num=null;
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select num from shop order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getString("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return num;
		
	}
	
	//num���� �޾Ƽ� �ش� dto�ϳ��� ��������
	public ShopDto getOneShop(String num) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from shop where num=?";
		ShopDto dto = new ShopDto();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, num);
			//����
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setTelephone(rs.getString("telephone"));
				dto.setTag(rs.getString("tag"));
				dto.setPhoto(rs.getString("photo"));
				dto.setParking(rs.getString("parking"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setOpening(rs.getInt("opening"));
				dto.setClosing(rs.getInt("closing"));

				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
		
	}

}
