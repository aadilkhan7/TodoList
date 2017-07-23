package com.ConnectionToDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

	private static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String Password = "aadilkhan7";
			String Host = "jdbc:mysql://localhost/todo";
			String User = "root";
			java.sql.Connection con = DriverManager.getConnection(Host, User, Password);

			System.out.println(con.isClosed());
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

}
