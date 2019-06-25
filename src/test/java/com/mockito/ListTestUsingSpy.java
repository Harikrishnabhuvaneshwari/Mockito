package com.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTestUsingSpy {
	
	/**
	 * spy --> partial mocking
	 */
	@Test
	public void testListMethods_UsingSpy() {
		List list=spy(ArrayList.class);  // provides the object with its full implementation instead of mocking them
		list.add("arerf");
		assertThat(list.size(), is(1));
		assertEquals(list.get(0),"arerf");
	}

}
