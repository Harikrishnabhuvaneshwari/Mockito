package com.mockito;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Hamcrest library provides methods which are easy to Understand, and improves the test readability,maintainable.
 * @author hprakash
 *
 */
public class HamcrestLibraryTest {

	@Test
	public void testHamCrestLibrary_Methods() {
		//list testing.
		//consider this list as an o/p from some service methods.
		List<Integer> marks=Arrays.asList(67,43,89,96,45);
		assertThat(marks,hasSize(5));
		assertThat(marks,hasItems(43,45));
		assertThat(marks,containsInAnyOrder(45,67,96,89,43));
		assertThat(marks,everyItem(greaterThan(35)));

		//String testing
		assertThat("",isEmptyString());
		assertThat(null,isEmptyOrNullString());
		assertThat("Hari",containsString("ar"));
		assertThat("Hari".length(),is(4));
		
		//Array
		Integer[] tempArray={3,6,8,1,2};
		assertThat(tempArray,arrayContainingInAnyOrder(8,2,1,6,3));
		assertThat(tempArray,arrayWithSize(5));
		
	}

}
