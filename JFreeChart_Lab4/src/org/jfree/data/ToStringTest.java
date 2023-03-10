package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class ToStringTest {
	
	private Range exampleRange;
	
	@Test
	public void toStringPositiveNegativeRange() {
		// This test covers a range that is both negative and positive (ECT)
		exampleRange = new Range(-1, 1);
		assertEquals("The range string should be Range[-1,1]",
		        "Range["+Double.toString(-1) + "," + Double.toString(1) + "]",exampleRange.toString());
	}
	
	@Test
	public void toStringNegativeRange() {
		// This test covers a range that is entirely below 0 (ECT)
		exampleRange = new Range(-10, -3);
		assertEquals("The range string should be Range[-10,-3]",
		        "Range["+Double.toString(-10) + "," + Double.toString(-3) + "]",exampleRange.toString());
	}
	
	@Test
	public void toStringPositiveRange() {
		// This test covers a range that is entirely above 0 (ECT)
		exampleRange = new Range(5, 100);
		assertEquals("The range string should be Range[5,100]",
		        "Range["+Double.toString(5) + "," + Double.toString(100) + "]",exampleRange.toString());
	}
	
	
	


}
