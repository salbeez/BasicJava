package com.Ex.postgres;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;


/**
 * @author ji
 * @First Postgres db Test
 */
public class JdbcTest {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	public JdbcTest() {
		try {
			pro = new Properties();
			pro.load(new FileReader("D:/git/BasicJava/conn/conn.properties"));
			System.out.println(pro.keySet());
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vector<UserInfo> users = selectTest();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getId());
		}
		System.out.println("검색된 행의 수 : "+users.size());
	}

	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {// DB자원 반환
		try {
			if (rs != null)
				rs.close();
			// if(stmt!=null)stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect

	public Vector<UserInfo> selectTest() {
		connect();
		Vector<UserInfo> users = new Vector<>();
		
		String sql = "select * from customer";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// 한 행 얻기
				UserInfo user = new UserInfo();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setHiredate(rs.getString(3));
				user.setSal(rs.getString(4));
				user.setDname(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return users;
	}

	public static void main(String[] args) {
		new JdbcTest();
	}
}
