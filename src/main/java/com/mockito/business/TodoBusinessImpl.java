package com.mockito.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mockito.api.TodoService;

//TodoBusinessImpl is the SUT(System Under Test)
//TodoService is the dependency
public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = new ArrayList<>();
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		todoService.retrieveTodos(user);
		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user){
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodos(todo);
			}
		}
	}
}