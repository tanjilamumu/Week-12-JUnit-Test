package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;







class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPOsitiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
	
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
			
		}
	
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		//@formatter:off
		return Stream.of (
				arguments(2, 4, 6, false),
				arguments(-1, 5, 4, true),
				arguments(0, 0, 0, true),
				arguments(6, 23, 29, false),
				arguments(4, 0, 4, true),
				arguments(-1, -4, -5, true),
				arguments(0, 21, 21, true),
				arguments(25, -14, 11, true),
				arguments(20, 20, 40, false)	
				);
		//@formatter:on
	}
	

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
}

	