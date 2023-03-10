package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ConstrainTest {
	private Range exampleRange;
	private double expectedValue;
	private double constrainValue;
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-5.7, 9.1);
	}

	@Test
	// This test covers a value below the lower bounds of the range (ECT)
	public void belowRangeTest() {
		expectedValue = -5.7;
		constrainValue = -20.134;
		double actualValue = exampleRange.constrain(constrainValue);
		assertEquals("Actual value should be -5.7", expectedValue, actualValue, .000000001d);
	}
	
	@Test
	// This test covers a value on the lower bounds of the range (BVT)
	public void onLowerBoundTest() {
		expectedValue = -5.7;
		constrainValue = -5.7;
		double actualValue = exampleRange.constrain(constrainValue);
		assertEquals("Actual value should be -5.7", expectedValue, actualValue, .000000001d);
	}
	
	@Test
	// This test covers a value within the bounds of the range (ECT)
	public void withinRangeTest() {
		expectedValue = 2.3;
		constrainValue = 2.3;
		double actualValue = exampleRange.constrain(constrainValue);
		assertEquals("Actual value should be 2.3", actualValue, expectedValue, .000000001d);
	}
	
	@Test
	// This test covers a value on the upper bound of the range (BVT)
	public void onUpperBoundTest() {
		expectedValue = 9.1;
		constrainValue = 9.1;
		double actualValue = exampleRange.constrain(constrainValue);
		assertEquals("Actual value should be 9.1", expectedValue, actualValue, .000000001d);
	}
	
	@Test
	// This test covers a value that is above the upper bound of the range (ECT)
	public void aboveRangeTest() {
		expectedValue = 9.1;
		constrainValue = 18.725;
		double actualValue = exampleRange.constrain(constrainValue);
		assertEquals("Actual value should be 9.1", expectedValue, actualValue, .000000001d);
	}

}

