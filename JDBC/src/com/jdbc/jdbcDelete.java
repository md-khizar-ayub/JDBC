package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDelete {
	public static void main(String[] args) throws SQLException {
		System.out.println("Start");

		String url = "jdbc:mysql://localhost:3306/mka";
		String userName = "root";
		String userPwd = "root";

		String sql_delet = "Delete from employee where id = 1 ";
		String sql_selet = "Select id, name , salart from employee ";
		Connection con = DriverManager.getConnection(url, userName, userPwd);
		try {

//		Class.forName("com.mysql.jdbc.Driver");
			Statement st = con.createStatement();

			if(st.executeUpdate(sql_delet)>=1) {
				System.out.println("Deleted");
			}
			System.out.println("id" + "  |" + "  name" + " |" + "   salary");
			ResultSet rs = st.executeQuery(sql_selet);
			while (rs.next()) {
				System.out
						.println(rs.getInt("id") + "   |   " + rs.getString("name") + "   |   " + rs.getInt("salart"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

		System.out.println("End");
	}
}
