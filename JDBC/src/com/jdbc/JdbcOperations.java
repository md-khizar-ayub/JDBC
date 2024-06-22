package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcOperations {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Start");

		String url = "jdbc:mysql://localhost:3306/mka";
		String userName = "root";
		String userPwd = "root";

		String sql_selet = "Select id, name , salart from employee ";
		try {

//		Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, userPwd);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql_selet);
			System.out.println("id" + "  |" + "  name" + " |" + "   salary");
			while (rs.next()) {
				System.out
						.println(rs.getInt("id") + "   |   " + rs.getString("name") + "   |   " + rs.getInt("salart"));
			}

		} catch (SQLException e) {
		e.printStackTrace();
	}

		System.out.println("End");

	}

}
