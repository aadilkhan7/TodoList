package com.Todo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {

	private String task;
	private Date due;

	Todo() {

	}

	Todo(String task) {
		this.task = task;
		this.due = new Date();
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

}
