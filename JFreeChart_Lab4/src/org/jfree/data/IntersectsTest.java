package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class IntersectsTest {
	private Range baseRange;
	private double lower;
	private double upper;
	
	@Before
	public void setUp() throws Exception {
		baseRange = new Range(-10.5, 10.5);
	}

	@Test
	// This test covers both an upper and lower value below the range, lower < upper (ECT)
	public void lowerAndUpperBelowRangeTest() {
		lower = -12.4;
		upper = -11.1;
		boolean actual = baseRange.intersects(lower, upper);
		assertFalse("The range should not be intersected", actual);
	}
	
	@Test
	// This test covers a lower value below the range and an upper value within the range (ECT)
	public void lowerBelowAndUpperWithinRangeTest() {
		lower = -12.4;
		upper = -9.7;
		boolean actual = baseRange.intersects(lower, upper);
		assertTrue("The range should be intersected", actual);
	}
	
	@Test
	// This test covers a lower value below the range and an upper value above the range (ECT)
	public void lowerBelowAndUpperAboveRangeTest() {
		lower = -12.4;
		upper = 13.8;
		boolean actual = baseRange.intersects(lower, upper);
		assertTrue("The range should be intersected", actual);
	}
	
	@Test
	// This test covers an upper and lower value within the range, lower < upper (ECT)
	public void lowerWithinAndUpperWithinRangeTest() {
		lower = -8.6;
		upper = 5.4;
		boolean actual = baseRange.intersects(lower, upper);
		assertTrue("The range should be intersected", actual);
	}
	
	@Test
	// This test covers a lower value within the range, and an upper value above the range (ECT)
	public void lowerWithinAndUpperAboveRangeTest() {
		lower = -8.6;
		upper = 13.8;
		boolean actual = baseRange.intersects(lower, upper);
		assertTrue("The range should be intersected", actual);
	}
	
	@Test
	// This test covers an upper and lower value above the range, lower < upper (ECT)
	public void lowerAboveAndUpperAboveRangeTest() {
		lower = 10.7;
		upper = 13.8;
		boolean actual = baseRange.intersects(lower, upper);
		assertFalse("The range should not be intersected", actual);
	}

}
