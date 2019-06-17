package com.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.api.TodoService;
import com.mockito.business.TodoBusinessImpl;

//Testing TodoBusinessImpl class using Mockito(i.e., by mocking the objects).
public class TodoBusinessImplMockTest {

	@Test(expected=RuntimeException.class)
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoServiceMock=mock(TodoService.class);
		when(todoServiceMock.retrieveTodos(anyString())).thenThrow(new NullPointerException());
		TodoBusinessImpl todo=new TodoBusinessImpl(todoServiceMock);
		List<String> result = todo.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2,result.size());
		assertEquals(Arrays.asList("Learn Spring MVC","Learn Spring"),result);
	}

}
