package com.Todo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;

import com.Todo.Todo;

@Path("/TodoService")
public class TodoService {
	TodoDAO todoDao = new TodoDAO();

	@POST
	@Path("/task/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addTask(@FormParam("taskName") String task, @FormParam("dueDate") Date dueDate,
			@Context HttpServletResponse servletResponse) throws IOException {
		Todo todo = new Todo(task, dueDate);
		int result = todoDao.addTask(todo);
		if (result == 1) {
			return "SUCCESS_RESULT";
		}
		return "FAILURE_RESULT";
	}

	@GET
	@Path("/task/showtasks")
	@Produces(MediaType.APPLICATION_XML)
	public List<Todo> getAllTasks() {
		List<Todo> ls = todoDao.getAllTasks();
		System.out.println(ls);
		return ls;
	}

}
