package com.mockito.api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(String.class)
public class StringTest {

	@Test
	public void test() {
		//given
		PowerMockito.mockStatic(String.class);
		given(String.valueOf(1)).willReturn("1");

		//then
		assertThat(String.valueOf(1), is("1"));
	}

}
