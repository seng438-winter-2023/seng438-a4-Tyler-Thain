package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EqualTest {

	@Before
	public void setUp() throws Exception {
	}

	// This test covers when both a and b are null
	@Test
	public void aNullbNullTest() {
		double[][] a = null;
		double[][] b = null;
		boolean actual = DataUtilities.equal(a, b);
		assertTrue("Arrays should be equal.", actual);
	}
	
	// This test covers when a is null, and b is a valid object
	@Test
	public void aNullbNotNullTest() {
		double[][] a = null;
		double[][] b = {{0.0, 0.1}, {0.2, 0.3}};
		boolean actual = DataUtilities.equal(a, b);
		assertFalse("Arrays should not be equal.", actual);
	}
	
	// This test covers when a is a valid object, and b is null
	@Test
	public void aNotNullbNullTest() {
		double[][] a = {{0.0, 0.1}, {0.2, 0.3}};
		double[][] b = null;
		boolean actual = DataUtilities.equal(a, b);
		assertFalse("Arrays should not be equal.", actual);
	}
	
	// This test covers when a and b are different lengths
	@Test
	public void differentLengthTest() {
		double[][] a = {{0.0, 0.1}, {0.2, 0.3}, {0.4, 0.5}};
		double[][] b = {{0.0, 0.1}, {0.2, 0.3}};
		boolean actual = DataUtilities.equal(a, b);
		assertFalse("Arrays should not be equal.", actual);
	}
	
	// This test covers when a and b are the same length, but not equal
	@Test
	public void sameLengthNotEqualTest() {
		double[][] a = {{1.0, 1.1}, {1.2, 1.3}};
		double[][] b = {{0.0, 0.1}, {0.2, 0.3}};
		boolean actual = DataUtilities.equal(a, b);
		assertFalse("Arrays should not be equal.", actual);
	}
	
	// This test covers when a and b are the same length and are equal
	@Test
	public void sameLengthAndEqualTest() {
		double[][] a = {{0.0, 0.1}, {0.2, 0.3}};
		double[][] b = {{0.0, 0.1}, {0.2, 0.3}};
		boolean actual = DataUtilities.equal(a, b);
		assertTrue("Arrays should not be equal.", actual);
	}

}
