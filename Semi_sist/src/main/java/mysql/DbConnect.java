package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	
	static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/sist";
	static final String MYSQL_CLOUDE = "jdbc:mysql://database-1.cn446nf2xi4h.us-east-2.rds.amazonaws.com:3306/sist";
	
	//������
	public DbConnect() {
		try {
			Class.forName(MYSQLDRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql ����̹� ����: "+e.getMessage());
		}
	}
	
	//Connection
	public Connection getConnection() {
		Connection conn=null;
		
		try {
			conn = DriverManager.getConnection(MYSQL_CLOUDE, "admin", "12345678");
		} catch (SQLException e) {
			System.out.println("Mysql �������: " + e.getMessage());
		}
		return conn;
	}
	
	//close �޼ҵ� �� 4��, �����ε� �޼ҵ�
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			
		}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			
		}
	}
	
	public void dbClose(Statement stmt, Connection conn) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			
		}
	}
	
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			
		}
	}
}
