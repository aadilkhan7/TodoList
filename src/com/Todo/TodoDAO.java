package com.Todo;

import com.ConnectionToDB.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TodoDAO {
	int count;

	int addTask(Todo todo) {
		try {

			Connection con = MySQLConnection.getConnection();
			String addTask = "insert into todoList (task, dueDate) values (?, ? )";
			PreparedStatement smt = con.prepareStatement(addTask);
			smt.setString(1, todo.getTask());
			smt.setDate(2, (java.sql.Date) todo.getDue());
			int i = smt.executeUpdate();
			con.close();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	List<Todo> getAllTasks() {
		List<Todo> allTasks = new ArrayList<Todo>();
		try {
			// Connection con = MySQLConnection.getConnection();
			// String getTasks = "select * from todoList";
			// Statement st = con.createStatement();
			// ResultSet rs = st.executeQuery(getTasks);
			// while (rs.next()) {
			// String a = rs.getString(2);
			// Date b = rs.getDate(3);
			// Todo task = new Todo(a, b);
			// allTasks.add(task);
			// }
			// con.close();
			// Todo t1 = new Todo("goto library");
			// Todo t2 = new Todo("finish todo");
			// allTasks.add(t1);
			// allTasks.add(t2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTasks;
	}

}
