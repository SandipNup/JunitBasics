package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing Math Utils")
class MathUtilsTest {
	
	private MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	
	@AfterAll
	static void afterALl() {
		System.out.println("This test will run after all");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + testInfo.getTags());

	}
	
	@AfterEach
	void cleanup() {
	}

	@RepeatedTest(3)
	@Tag("Math")
	@DisplayName("Testing Math Utils add Method")
	void testAdd(RepetitionInfo repetitionInfo) {
		int expected = 3;
		int actual = mathUtils.add(2, 1);
		assertEquals(expected, actual, "The add method should add to numbers");
	}
	
	@Test
	@Tag("Circle")
	void testComputeCircleRadius() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314, mathUtils.computeCircleArea(10), "Should return the area of the circle");
	}
	
	@Test
//	@EnabledOnOs(OS.LINUX)
	@Tag("Math")
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(false);
		MathUtils mathUtils = new MathUtils();
		assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1,0), "Divide by zero should throw");
		
	}
	
	@Test
	@DisplayName("Test multiply method")
	@Tag("Math")
	void testMultiply() {
		System.out.println("Running " + testInfo.getDisplayName() + testInfo.getTags());
		MathUtils mathUtils = new MathUtils();
//		assertEquals(6, mathUtils.multiply(2,3), "should return the multiple");
		assertAll(
				() -> assertEquals(6, mathUtils.multiply(2,3),()-> "should return the multiple"),
				() -> assertEquals(8, mathUtils.multiply(2,4),()-> "should return the multiple"),
				() -> assertEquals(10, mathUtils.multiply(2,5),()-> "should return the multiple")
				);
	}
	
	@Test
	@DisplayName("TDD method should not run")
	@Disabled
	void failTestCheck() {
		fail("The test should be disabled");
	}
	
	@Nested
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("Testing Math Utils add Method for positive")
		void testAddPositive() {
			String str;
			Integer num1 = new Integer(1);
			Integer num2 = num1;
			num1 +=1;
			System.out.println(num1);
			System.out.println(num2);
			assertEquals(3, mathUtils.add(2, 1),()-> "The add method should add positive numbers");
		}
		
		@Test
		@DisplayName("Testing Math Utils add Method for negative")
		void testAddNeagtive() {
			assertEquals(-5, mathUtils.add(-2, -3),()-> "The add method should add positive numbers");
		}
	}
}
