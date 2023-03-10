package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class CalculateColumnTotalTest extends DataUtilities {
	@Test
	public void validInputTest() {
		// This test covers a valid input for data and row (ECT)
	
	    //Mock does not work with EclEmma so test written with actual dependency 
	    DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	    values.setValue(2.5, 0, 0);
	    values.setValue(7.5, 1, 0);
	    double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Total should be 10 for valid input for index 0", 10, result, .000000001d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullDataTest() {
		// This test covers an invalid input for data and a valid input for row (ECT)
	    double actual = DataUtilities.calculateColumnTotal(null, 1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void negativeIndexTest() {
		// This test covers an invalid input for row and a valid input for data (BVT)
		
		//Mock does not work with EclEmma so test written with actual dependency 
	    DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	    values.setValue(2.5, 0, 0);
	    values.setValue(7.5, 1, 0);
	    
		double result = DataUtilities.calculateColumnTotal(values, -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void tooLargeIndexTest() {
		// This test covers an invalid input for row and a valid input for data (BVT)

		//Mock does not work with EclEmma so test written with actual dependency 
	    DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	    values.setValue(2.5, 0, 0);
	    values.setValue(7.5, 1, 0);
		double result = DataUtilities.calculateColumnTotal(values, 10);

	}

}
