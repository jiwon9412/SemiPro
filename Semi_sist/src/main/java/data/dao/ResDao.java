package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.ResDto;
import mysql.DbConnect;

public class ResDao {
	
	DbConnect db = new DbConnect();
	
	//insert
	public void insertRes(ResDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into reservation(login_num, shop_num,shop_name, res_date, persons, price, paymentdate, seat)"
				+ " values(null, null, ?, ?, ?, ?, now(), ?)"; //login, shop num �߰� �ʿ�
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//���ε�
			//pstmt.setString(1, dto.getLogin_num()); //login num ���� �ʿ�
			//pstmt.setString(2, dto.getShop_num()); //shop num �߰� �ʿ�
			pstmt.setString(1, dto.getShop_name());
			pstmt.setString(2, dto.getRes_date());
			pstmt.setString(3, dto.getPersons());
			pstmt.setString(4, dto.getPrice());
			pstmt.setString(5, dto.getSeat());
		
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
	//�ֱ� ������ �ϳ� (����Ϸ� ��)
	public ResDto getLatestData() {
		ResDto dto = new ResDto();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation order by num desc limit 1";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setLogin_num(rs.getString("login_num"));
				dto.setShop_num(rs.getString("shop_num"));
				dto.setShop_name(rs.getString("shop_name"));
				dto.setRes_date(rs.getString("res_date"));
				dto.setPersons(rs.getString("persons"));
				dto.setPrice(rs.getString("price"));
				dto.setSeat(rs.getString("seat"));
				dto.setPaymentdate(rs.getTimestamp("paymentdate"));	
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
