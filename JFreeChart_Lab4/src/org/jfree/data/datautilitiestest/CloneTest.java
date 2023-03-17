package org.jfree.data.datautilitiestest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Test;

public class CloneTest {

	@Before
	public void setUp() throws Exception {
	}
	
	// This test covers when the source object is valid
	@Test
	public void notNullTest() {
		double[][] source = {{0.0}, {0.1}};
		double[][] clone = DataUtilities.clone(source);
		assertTrue("Arrays should be equal", Arrays.deepEquals(source, clone));
	}
	
	// This test covers when the source object is null
	@Test(expected = IllegalArgumentException.class)
	public void nullSourceTest() {
		double[][] source = null;
		double[][] clone = DataUtilities.clone(source);
	}
	
	// This test covers when the source contains a null value
		@Test
		public void sourceWithNullTest() {
			double[][] source = {null, {0.1}};
			double[][] clone = DataUtilities.clone(source);
			assertTrue("Arrays should be equal", Arrays.deepEquals(source, clone));
		}

}
