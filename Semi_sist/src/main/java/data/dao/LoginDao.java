package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import data.dto.LoginDto;
import mysql.DbConnect;

public class LoginDao {
	
	DbConnect db = new DbConnect();
	
	//login_num�޾Ƽ� ���� �����;��_1��
	public LoginDto getOneData(String num) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		LoginDto dto = new LoginDto();
		String sql="select * from login where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setNum(rs.getString("num"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setNick(rs.getString("nick"));
				dto.setEmail(rs.getString("email"));
				dto.setHp(rs.getString("hp"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGaipday(rs.getTimestamp("gaipday"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return dto;
		
	}
	
	/* ���⼭���� ���� ���� ���� 211104 16:50 */
	
	// ���̵� üũ_boolean(String id)
	public boolean isIdCheck(String id) {

		boolean isid = false;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from login where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			// ���ε�
			pstmt.setString(1, id);
			// ����
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// �ش� ���̵� �����Ұ�� true
				isid = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return isid;

	}

	// ���̵� ���� nick(String id)
	public String getNick(String id) {

		String nick = "";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from login where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			// ���ε�
			pstmt.setString(1, id);
			// ����
			rs = pstmt.executeQuery();

			if (rs.next()) {
				nick = rs.getString("nick");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return nick;

	}
	
	// insert
	public void insertData(LoginDto dto) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into login values(null,?,?,?,?,?,?,now())";

		try {
			pstmt = conn.prepareStatement(sql);
			// ���ε�
			pstmt.setString(1, dto.getNick());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPhoto());
			// ����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	
}
