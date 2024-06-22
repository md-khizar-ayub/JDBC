package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {

	public static void main(String[] args) throws SQLException {
		System.out.println("Starts");

		String url = "jdbc:mysql://localhost:3306/mka";
		String userName = "root";
		String userPwd = "root";

		String sql_selet = "Select id, name , salart from employee ";
		String sql_update = "Update employee set name ='A' where id = ? ";
		Connection con = DriverManager.getConnection(url, userName, userPwd);
		try {

//		Class.forName("com.mysql.jdbc.Driver");

			Statement st = con.createStatement();
			
			select(st, sql_selet);
			
			PreparedStatement ps = con.prepareStatement(sql_update);
			ps.setInt(1, 1);
			if (ps.executeUpdate()>=1)
				System.out.println("Excecuted");
			
			select(st, sql_selet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		System.out.println("Ends");
	}

	public static void select(Statement st, String sql_selet) {

		try {
			ResultSet rs = st.executeQuery(sql_selet);
			System.out.println("id" + "  |" + "  name" + " |" + "   salary");
			while (rs.next()) {
				System.out
						.println(rs.getInt("id") + "   |   " + rs.getString("name") + "   |   " + rs.getInt("salart"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
