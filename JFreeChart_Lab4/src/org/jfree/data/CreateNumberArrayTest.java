// createNumberArrayTest.java

package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNumberArrayTest {

    @Before
    public void setUp() throws Exception {
    	
    }

    // Test for null data parameter	
    @Test(expected = IllegalArgumentException.class)
	public void nullInputTest() throws IllegalArgumentException {
		Number[] actual = DataUtilities.createNumberArray(null);
	}
	
    // Test for valid data parameter
    @Test
	public void validInputTest() {
		Number[] expected = {-1.1, 0.0, 15.6};
		double[] input = {-1.1, 0.0, 15.6};
		Number[] actual = DataUtilities.createNumberArray(input);
		assertArrayEquals("The actual array should contain the following: {-1.1, 0.0, 15.6}", expected, actual);
	}

    @After
    public void tearDown() throws Exception {
		
    }

}
