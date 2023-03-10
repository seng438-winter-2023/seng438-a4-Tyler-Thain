package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNumberArray2DTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullInputTest() throws IllegalArgumentException {
		// This test covers when data is null (ECT)
		Number[][] actual = DataUtilities.createNumberArray2D(null);
	}
	
	@Test
	public void validInputTest() {
		// This test covers when data is a valid 2D double array (ECT)
		Number[][] expected = {{1.1, 2.3}, {1.5, 1.7}, {3.8, 82.1}};
		double[][] input = {{1.1, 2.3}, {1.5, 1.7}, {3.8, 82.1}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertArrayEquals("The actual array should contain the following: {{1.1, 2.3}, {1.5, 1.7}, {3.8, 82.1}}",
				expected, actual);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

}
