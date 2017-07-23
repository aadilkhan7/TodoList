package com.Todo;

import com.ConnectionToDB.MySQLConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TodoDAO {
	int count;

	int addTask(Todo todo) {
		try {

			Connection con = MySQLConnection.getConnection();
			String addTask = "insert into todoList (task, dueDate) values (?, ?)";
			PreparedStatement smt = con.prepareStatement(addTask);
			smt.setString(1, todo.getTask());
			smt.setDate(2, todo.getDue());
			int i = smt.executeUpdate();
			con.close();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	List<TodoUtil> getAllTasks() {
		List<TodoUtil> allTasks = new ArrayList<TodoUtil>();
		try {
			Connection con = MySQLConnection.getConnection();
			String getTasks = "select * from todoList";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(getTasks);
			while (rs.next()) {
				String a = rs.getString(2);
				java.util.Date b = (java.util.Date) rs.getDate(3);
				System.out.println("getAllTask " + a + " " + b);
				TodoUtil task = new TodoUtil(a, b);
				allTasks.add(task);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTasks;
	}

}
