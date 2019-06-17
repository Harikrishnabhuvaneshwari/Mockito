package com.mockito;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.api.ToDoServiceStub;
import com.mockito.business.TodoBusinessImpl;

//Testing TodoBusinessImpl class using Stub dependency
public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoBusinessImpl todo=new TodoBusinessImpl(new ToDoServiceStub());
		List<String> result = todo.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2,result.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring2_usingAStub() {
		TodoBusinessImpl todo=new TodoBusinessImpl(new ToDoServiceStub());
		List<String> result = todo.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(Arrays.asList("Learn Spring MVC","Learn Spring"),result);
	}

}
