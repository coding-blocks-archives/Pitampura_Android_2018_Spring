package com.codingblocks.sqliteintro.models;

public class Todo{
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private String task;
	private boolean done;

	public void setTask(String task){
		this.task = task;
	}

	public String getTask(){
		return task;
	}

	public void setDone(boolean done){
		this.done = done;
	}

	public boolean isDone(){
		return done;
	}

	@Override
 	public String toString(){
		return 
			"Todo{" + 
			"task = '" + task + '\'' + 
			",done = '" + done + '\'' + 
			"}";
		}
}
