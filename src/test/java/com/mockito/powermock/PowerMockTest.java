package com.mockito.powermock;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)   
@PrepareForTest(UtilityClass.class)
public class PowerMockTest {

	//	@Rule
	//	public MockitoRule mockRule=MockitoJUnit.rule();

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void testMethodCallingAStaticMethod(){
		given(dependency.retrieveAllStats()).willReturn(Arrays.asList(1,2,3));
		PowerMockito.mockStatic(UtilityClass.class);
		given(UtilityClass.staticMethod(Mockito.anyInt())).willReturn(6);

		assertThat(dependency.retrieveAllStats(),is(Arrays.asList(1,2,3)));
		assertThat(systemUnderTest.methodCallingAStaticMethod(),is(6));

		//verifying whether static method with specified parameter is called or not
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
	}
}
