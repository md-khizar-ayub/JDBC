package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {

	public static void main(String[] args) throws SQLException {
		System.out.println("Start");

		String url = "jdbc:mysql://localhost:3306/mka";
		String userName = "root";
		String userPwd = "root";

		String sql_insert = "insert into employee (id, name, salart) values (?,?,?) ";
		String sql_selet = "Select id, name , salart from employee ";
		Connection con = DriverManager.getConnection(url, userName, userPwd);
		try {

//		Class.forName("com.mysql.jdbc.Driver");
			
			PreparedStatement ps = con.prepareStatement(sql_insert);
			ps.setInt(1, 1);
			ps.setString(2, "A");
			ps.setInt(3, 10230);
			
			if(ps.executeUpdate()>=1)
				System.out.println("Inserted");
			
			
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql_selet);
			System.out.println("id" + "  |" + "  name" + " |" + "   salary");
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
