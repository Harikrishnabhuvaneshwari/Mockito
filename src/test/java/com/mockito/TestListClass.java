package com.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestListClass {

	List mockedListObject;

	@Before
	public void setUp(){
		mockedListObject=mock(List.class);
	}

	@Test
	public void testListClassSizeMethod_UsingMock() {
		when(mockedListObject.size()).thenReturn(10);
		assertEquals(10,mockedListObject.size());
	}

	@Test
	public void testListClassGetMethod_UsingMock(){
		when(mockedListObject.get(1)).thenReturn("Mockito");
		assertEquals("Mockito",mockedListObject.get(1));
		assertEquals(null,mockedListObject.get(anyInt()));  //Nice Mock - as it provides a default values for what(inputs) we haven't set.
	}

	//setting multiple outputs for the sequential calls
	@Test
	public void testListClassGetMethod_UsingMockMultipleReturns(){
		when(mockedListObject.get(1)).thenReturn("Mockito").thenReturn("BBD");
		assertEquals("Mockito",mockedListObject.get(1));
		assertEquals(null,mockedListObject.get(anyInt()));  //Nice Mock - as it provides a default values for what(inputs) we haven't set.
		assertEquals("BBD",mockedListObject.get(1));
	}

	//Using Argument_Matcher
	@Test
	public void testListClassGetMethod_UsingMockAnyMatcher(){
		when(mockedListObject.get(anyInt())).thenReturn("Mockito");
		for(int i=0;i<100000;i++){
			assertEquals("Mockito",mockedListObject.get(i));
		}
	}

	//Throwing runtime exceptions
	@Test(expected=NullPointerException.class)
	public void testListClassGetMethod_UsingMockThenThrow(){
		when(mockedListObject.get(anyInt())).thenThrow(new NullPointerException());
		mockedListObject.get(34);
	}

	//Unstubbed methods --> when unstubbed methods are using Mockito's mocked object default
	//values of the respective method's return type is returned.
	@Test
	public void testListClassAllMethods_UsingMockButUnstubbed(){
		assertEquals(0, mockedListObject.size());
		assertEquals(null,mockedListObject.get(anyInt()));
		assertFalse(mockedListObject.contains(anyString()));
		assertEquals(null,mockedListObject.iterator());
	}
}
