package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	private Range getlowerbound1;
	private Range getlowerbound2;
	private Range getlowerbound3;
	private Range getupperbound1;
	private Range getupperbound2;
	private Range getupperbound3;
	private Range baseRange;
	private Range testRange;
	private double lower;
	private double upper;
	private Range exampleRange;
	private double expectedValue;
	private double constrainValue;
	
	
	
	// -------------- rangeTest ------------------------
	
	// Testing the constructor when the Lower is greater
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorLowerBoundGreater() {
		testRange = new Range(3, 2);
		assertEquals("The lower bound value should be null", testRange);
	}
	
	
    // -------------- GetLowerBoundTest ----------------
	
	
 
    @Before
    public void setUp() throws Exception { 
    	getlowerbound1 = new Range(-1, 1);
    	getlowerbound2 = new Range(13, 76);
    	getlowerbound3 = new Range(-20, -7);
    }
    
	// This test covers data for a negative and positive
    @Test
    public void testGetLowerBoundNegPos() {
        assertEquals("The Lower Bound for -1 and 1 should be 1",
        -1, getlowerbound1.getLowerBound(), .000000001d);
    }
    
	// This test covers data for two positives
    @Test
    public void testGetLowerBound2Positive() {
    	assertEquals("The Lower Bound for 13 and 76 should be 13", 
    	13, getlowerbound2.getLowerBound(), .000000001d);
    }
    
	// THis test covers data for two negatives
    @Test
    public void testGetLowerBound2Negatives() {
    	assertEquals("The Lower Bound for -20 and -7 should be -20", 
    	-20, getlowerbound3.getLowerBound(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    
    
    
    // --------------- intersectsTest ------------------
    
    
    @Before
	public void setUpIntesects() throws Exception {
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
	
	@Test
	public void intersectRange() {
		Range ex_range = new Range(-8.6, 5.4);
		boolean actual = baseRange.intersects(ex_range);
		assertTrue("The range should be intersected", actual);
	}
	
	
	
	
	// ----------------------- shiftTest -------------------------
	
	


    @Before
    public void setUpShift() throws Exception {
    	
    }

   
    // Test when delta == 0
	@Test
    public void testZeroShift() {
    	Range range1 = new Range(5, 7);
    	assertEquals("Range(5, 7) shifted by 0 should result Range(5, 7)", range1, Range.shift(range1, 0));
    }	

    // Test positive delta with positive Range
    @Test
    public void testPositivesDelta() {
    	Range range1 = new Range(5, 7);
    	Range range2 = new Range(7, 9);
    	assertEquals("Range(5, 7) shifted by 2 should result Range(7, 9)", range2, Range.shift(range1, 2));
    }

    // Test negative delta with positive Range
    @Test
    public void testNegativeDelta() {
    	Range range1 = new Range(5, 7);
    	Range range2 = new Range(3, 5);
    	assertEquals("Range(5, 7) shifted by -2 should result Range(3, 5)", range2, Range.shift(range1, -2));
    }
	
	// Test the zero crossing from negative is not allowed
	@Test
    public void testNegativeBoundary() {
    	Range range1 = new Range(-3, -1);
    	Range range2 = new Range(-1, 0);
    	assertEquals("Range(-3, -1) shifted by 2 should result Range(-1, 0)", range2, Range.shift(range1, 2));
    }	
	
	// Test the zero crossing from positive is not allowed
    @Test
    public void testPositiveBoundary() {
    	Range range1 = new Range(1, 3);
    	Range range2 = new Range(0, 1);
    	assertEquals("Range(1, 3) shifted by -2 should result Range(0, 1)", range2, Range.shift(range1, -2));
    }	
    
    @Test
	public void shiftByPositiveAllowZero() {
		testRange = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange, 158, true);
		assertEquals("The shifted value should be ", 164, testShiftedRange.getUpperBound(), .000000001d);
	}
    
    @Test
	public void shiftWithNoZeroCrossingValueEqualZero() {
		testRange = new Range(0, 6);
		Range testShiftedRange = Range.shift(testRange, 158, false);
		assertEquals("The shifted value should be ", 164, testShiftedRange.getUpperBound(), .000000001d);
	}

	
    @After
    public void tearDownShift() throws Exception {
		
    }

 
    
    // -------------------- constrainTest ---------------------
    
    
    
    @Before
	public void setUpConstrain() throws Exception {
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
	@After
    public void tearDownConstrain() throws Exception {
    }

	
	
	
	// -------------------- toStringTest ------------------------
	
	
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
	
	
	
	
	
	
	// ------------------ getUpperBoundTest -----------------
	
	


    @Before
    public void setUpUpper() throws Exception { 
    	getupperbound1 = new Range(-1, 1);
    	getupperbound2 = new Range(13, 76);
    	getupperbound3 = new Range(-20, -7);
    }

	// This test covers data for a negative and positive
    @Test
    public void testGetUpperBoundNegPos() {
        assertEquals("The Lower Bound for -1 and 1 should be 1",
        -1, getupperbound1.getLowerBound(), .000000001d);
    }
    
	// This test covers data for two positives
    @Test
    public void testGetUpperBound2Positive() {
    	assertEquals("The Lower Bound for 13 and 76 should be 13", 
    	13, getupperbound2.getLowerBound(), .000000001d);
    }
    
	// THis test covers data for two negatives
    @Test
    public void testGetUpperBound2Negatives() {
    	assertEquals("The Lower Bound for -20 and -7 should be -20", 
    	-20, getupperbound3.getLowerBound(), .000000001d);
    }

    @After
    public void tearDownUpper() throws Exception {
    }

 
    
    
    // --------------------- getLength ------------------
    
    
    // Test with 2 negatives
    @Test
    public void lengthShouldBeFive() {
	exampleRange = new Range (-10, -5);
	assertEquals("The length of -10 and -5 should be 5", 5, exampleRange.getLength(), .000000001d);
    }

    // Test with negative and zero
    @Test
    public void lengthShouldBeTen() {
	exampleRange = new Range (-10, 0);
	assertEquals("The length of -10 and 0 should be 10", 10, exampleRange.getLength(), .000000001d);
    }

    // Test with zero and a positive
    @Test
    public void lengthShouldBeFifteen() {
	exampleRange = new Range (0, 15);
	assertEquals("The length of 0 and 15 should be 15", 15, exampleRange.getLength(), .000000001d);
    }

    // Test with 2 positives
    @Test
    public void lengthShouldBeFourty() {
	exampleRange = new Range (20, 60);
	assertEquals("The length of 20 and 60 should be 40", 40, exampleRange.getLength(), .000000001d);
    }
    
    
    
    
    // ------------------- getCentralValue --------------------
    
    // Test with negative and positive
    @Test
    public void centralValueNegPos() {
    	exampleRange = new Range (-1.0,1.0);
	assertEquals("The central value of -1 and 1 should be 0", 0, exampleRange.getCentralValue(), .000000001d);
    }

    // Test with 2 negatives
    @Test
    public void centralValue2Neg() {
	exampleRange = new Range(-20, -10);
	assertEquals("The central value of -20 and -10 should be -15", -15, exampleRange.getCentralValue(), .000000001d);
    }

    // Test with 2 positives
    @Test
    public void centralValue2Pos() {
	exampleRange = new Range(10, 20);
	assertEquals("The central value of 10 and 20 should be 15", 15, exampleRange.getCentralValue(), .000000001d);
    }
    
    
    
    
    // -------------------- containsTest ------------------------
    
    // Test if a range contains a number
    @Test
    public void contains10() {
	exampleRange = new Range (5, 20);
	assertEquals("The range of 5 and 20 should contain 10", true, exampleRange.contains(10));
    }
    
    
    // -------------------- hashTest ---------------------
    
    // Test hash code when ranges are the same
    @Test
	public void hashcodeForSame() {
		Range range1 = new Range(0, 10);
		Range range2 = new Range(0, 10);
		assertEquals("Hashcode for two similar ranges are not the same.", range2.hashCode(), range1.hashCode());
	}
	
	// Test hash code when ranges are different
	@Test
	public void hashcodeForDifferent() {
		Range range1 = new Range(0, 10);
		Range range2 = new Range(2, 11);
		assertFalse("Hashcode for two different ranges are the same.", range1.hashCode() == range2.hashCode());
	}
	
	
	
	
	// ------------------- equalsTest -------------------
	
	@Before
	public void setUpEquals() throws Exception {
		testRange = new Range(2, 12);
	}
	
	// Test when a non Range object is given
	@Test
	public void NotRangeObject() {
		assertEquals("Testing non Range object with Range object", false, testRange.equals("Scott"));
	}
	
	// Test different Ranges to see if equal
	@Test
	public void DiffRangeObject1() {
		assertEquals("Testing two different Range objects", false, testRange.equals(new Range(10, 20)));
	}
	
	// Test the same Ranges
	@Test
	public void SameRangeObject() {
		assertEquals("Testing Range object with itself", true, testRange.equals(testRange));
	}
	
	// Test if only Lower is different
	@Test
	public void DiffLowerBound() {
		assertEquals("Testing two Range objects with same upper bound but different lower bound", false, testRange.equals(new Range(3, 12)));
	}
	
	// Test if only Upper is different
	@Test
	public void DiffUpperBound() {
		assertEquals("Testing two Range objects with same lower bound but different upper bound", false, testRange.equals(new Range(2, 16)));
	}
	
	
	
	
	// ----------------- combineTest ---------------------
	
	// Test combine upper when first Range is null
	@Test
	public void combineFirstParameterNullUpperBound() {
		Range tempRange = Range.combine(null, new Range(0, 10)); 
		double upperBound = tempRange.getUpperBound(); 
		assertEquals("The combined upper bound should be 10 and it is " + upperBound, 10, upperBound, .000000001d);
	}

	// Test combine lower when first Range is null
	@Test
	public void combineFirstParameterNullLowerBound() {
		Range tempRange = Range.combine(null, new Range(4, 10)); 
		double lowerBound = tempRange.getLowerBound(); 
		assertEquals("The combined lower bound should be 4 and it is " + lowerBound, 4, lowerBound, .000000001d);
	}

	// Test combine upper when second Range is null
	@Test
	public void combineSecondParameterNullUpperBound() {
		Range tempRange = Range.combine(new Range(-10, -1), null);
		double upperBound = tempRange.getUpperBound(); 
		assertEquals("The combined upper bound should be -1 and it is " + upperBound, -1, upperBound, .000000001d);
	}

	// Test combine lower when second Range is null
	@Test
	public void combineSecondParameterNullLowerBound() {
		Range tempRange = Range.combine(new Range(-10, -1), null); 
		double lowerBound = tempRange.getLowerBound(); 
		assertEquals("The combined lower bound should be -10 and it is " + lowerBound, -10, lowerBound, .000000001d);
	}

	// Test combine upper with no null Range
	@Test
	public void combineNoParametersNullUpperBound() {
		Range tempRange = Range.combine(new Range(1, 10), new Range(-10, -2)); 
		double upperBound = tempRange.getUpperBound(); 
		assertEquals("The combined upper bound should be 10 and it is " + upperBound, 10, upperBound, .000000001d);
	}

	// test combine lower with no null Range
	@Test
	public void combineNoParametersNullLowerBound() {
		Range tempRange = Range.combine(new Range(1, 10), new Range(-10, -2)); 
		double lowerBound = tempRange.getLowerBound(); 
		assertEquals("The combined lower bound should be -10 and it is " + lowerBound, -10, lowerBound, .000000001d);
	}
	
	
	
	// ----------------------- scaleTest ------------------
	
	// Test that a positive scale works
	@Test
	public void scalePositiveFactor() {
		Range testRange1 = new Range(0, 5);
		Range testScale = Range.scale(testRange1, 2);
		assertEquals("The shifted value should be ", 10, testScale.getUpperBound(), .000000001d);
	}
	
	// Test that negative scale is invalid
	@Test(expected = IllegalArgumentException.class)
    public void testNull() throws IllegalArgumentException{
		Range.scale(testRange, -1);
    }
	
	
	
	// -------------------- expandTest ------------------
	
	
	@Test
	public void expandTest() {
		Range testRange1 = new Range(1, 2); 
		Range testRange2 = Range.expand(testRange1, -0.9, -0.9); 
		assertEquals("The lower margin range will be 1.5", 1.5, testRange2.getLowerBound(), .000000001d);
	}
	
	
	// ------------------- expandToIncludeTest ----------------
	
	// Test expand on null
	@Test
	public void expandToIncludeNull() {
		Range nullRange = null; 
		Range testRange = Range.expandToInclude(nullRange, 1);
		assertEquals("The lower value will be 1", 1, testRange.getLowerBound(), .000000001d);
	}

	// Test expand to include something inside existing Range
	@Test
	public void expandToInlcudeInsideRange() { 
		Range testRange = Range.expandToInclude(new Range(4, 6), 5); 
		assertEquals("The upper value will be 6", 6, testRange.getUpperBound(), .000000001d);
	}

	// Test expand to include something outside existing Range upper
	@Test
	public void expandToInlcudeOutside() { 
		Range tempRange = Range.expandToInclude(new Range(1, 6), 12);
		assertEquals("The upper value will be 12", 12, tempRange.getUpperBound(), .000000001d);
	}

	// Test expand to include something outside existing Range lower
	@Test
	public void expandToInlcudeOutsideLower() {
		Range tempRange = Range.expandToInclude(new Range(2, 6), 1);
		assertEquals("The lower value will be 6", 6, tempRange.getUpperBound(), .000000001d);
	}

		
		
	// ----------------- combineIgnoringNaN -----------------
		
	// Test for valid Range and null Range
	@Test
	public void combineIgnoringNaN_Range1Null_Range2NotNull() {
		testRange = new Range(2, 6); 
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(null, testRange); 
		assertEquals("The returned object should be Range(2,6)", returnRange, testRange);
	}
	
	// Test for null Range combined with NaN Range
	@Test
	public void combineIgnoringNaN_Range1Null_Range2NaN() {
		double NaNParam = Math.sqrt(-1); 
		testRange = new Range(NaNParam, NaNParam); 
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(null, testRange); 
		assertNull("The return value should be null", returnRange);
	}

	// Test for 2 null Ranges
	@Test
	public void combineIgnoringNaN_Range1Null_Range2Null() {
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(null, null); 
		assertNull("The return value should be null", returnRange);
	}

	// Test NaN Range combined with null Range
	@Test
	public void combineIgnoringNaN_Range1NaN_Range2Null() {
		double NaNParam = Math.sqrt(-1); 
		testRange = new Range(NaNParam, NaNParam); 
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange, null); 
		assertNull("The return value should be null", returnRange);
	}

	// Test for valid Range combined with a null Range
	@Test
	public void combineIgnoringNaN_Range1NotNull_Range2Null() {
		testRange = new Range(2, 6); 
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange, null); 
		assertEquals("The return value should be Range(2,6)", returnRange, testRange);
	}

	// Test for 2 valid, not null Ranges
	@Test
	public void combineIgnoringNaN_Range1NotNull_Range2NotNull_NoNaN() {
		testRange = new Range(2, 6); 
		Range testRange2 = new Range(4, 7);
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange, testRange2); 
		assertEquals("The return value should be Range(2,7)", returnRange, new Range(2, 7));
	}

	// Test for combining 2 NaN Ranges
	@Test
	public void combineIgnoringNaN_Range1NotNull_Range2NotNull_AllNaN() {
		double NaNParam1 = Math.sqrt(-1); 
		double NaNParam2 = Math.sqrt(-2);
		testRange = new Range(NaNParam1, NaNParam2); 
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange, testRange); 
		assertNull("The return value should be null", returnRange);
	}
	
	// Test for combining a non NaN Range and a NaN Range
	@Test
	public void combineIgnoringNaN_Range1_Range2NaN() {
		double NaNParam = Math.sqrt(-1); 
		testRange = new Range(NaNParam, NaNParam); 
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(new Range(2,6), testRange); 
		assertEquals("The return value should be Range(2,6)", returnRange, new Range(2,6));
	}
}


