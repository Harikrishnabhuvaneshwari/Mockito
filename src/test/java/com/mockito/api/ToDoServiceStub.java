package com.mockito.api;

import java.util.Arrays;
import java.util.List;

/**
 * ToDoServiceStub is the stub here(i.e., sample implementation class for TodoService interface).
 * Disadvantages of Stub:
 * 1.If the conditions are too high then it makes spaghetti code in stub.
 * 2.If we add new methods to the interface then every time we need to alter our stub code.(time wastage)
 * 3.Not dynamic. 
 * @author hprakash
 *
 */
public class ToDoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
	}

	@Override
	public void deleteTodos(String todo) {
		
	}

}
