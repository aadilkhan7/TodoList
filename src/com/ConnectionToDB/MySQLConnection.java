package com.ConnectionToDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

	private static Connection con = null;

	public static Connection getConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String Password = "";
			String Host = "jdbc:mysql://localhost/todo";
			String User = "root";
			System.out.println("getting connection");
			con = DriverManager.getConnection(Host, User, Password);

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

}
