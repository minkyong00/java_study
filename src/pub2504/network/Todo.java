package pub2504.network;

import java.io.Serializable;

public class Todo implements Serializable {

	private static final long serialVersionUID = 246563233546345L;

	private String id;
	private String todo;
	private boolean completed;

	public Todo() {
	}

	public Todo(String id, String todo, boolean completed) {
		this.id = id;
		this.todo = todo;
		this.completed = completed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todo=" + todo + ", completed=" + completed + "]";
	}

}
