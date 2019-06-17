package com.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.verification.VerificationMode;

import com.mockito.api.TodoService;
import com.mockito.business.TodoBusinessImpl;

/**
 * 
 *Testing TodoBusinessImpl class using BBDMockito(i.e., by mocking the objects).
 *BBDMockito is an extension of Mockito but BDD encourages writing tests
 *in a natural, human-readable language that focuses on the behavior of the application.
 *Its basically has:
 *1.Given --> initial setup for the test
 *2.When --> invoking the particular method under test.
 *3.Then ---> asserting the result.
 *steps for writing the tests
 *
 * @author hprakash
 */
public class TodoBusinessImplBBDMockTest {

	//	@Test
	//	public void testRetrieveTodosRelatedToSpring_usingAStub() {
	//		//Given
	//		TodoService todoServiceMock=mock(TodoService.class);
	//		given(todoServiceMock.retrieveTodos(anyString())).willReturn(Arrays.asList("Learn Spring MVC","Learn Spring"));
	//		TodoBusinessImpl todo=new TodoBusinessImpl(todoServiceMock);
	//
	//		//When
	//		List<String> result = todo.retrieveTodosRelatedToSpring("Dy");
	//
	//		//Then
	//		assertThat(result,is(Arrays.asList("Learn Spring MVC","Learn Spring")));
	//		assertThat(result.size(),is(2));
	//	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingAStub(){
		//Given
		TodoService todoService=mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoService);
		given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Swim",""));

		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring(anyString());

		//Then
		verify(todoService,times(1)).deleteTodos("Learn to Swim");
		verify(todoService,never()).deleteTodos("Learn Spring MVC");

	}
	
	//ArgumentCaptor 
	@Test
	public void testDeleteTodosNotRelatedToSpring_ArgumentCaptor(){
		//Given
		TodoService todoService=mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoService);
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Swim",""));
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring(anyString());

		//Then
		then(todoService).should(times(2)).deleteTodos(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues(),is(Arrays.asList("Learn to Swim","")));

	}

}
