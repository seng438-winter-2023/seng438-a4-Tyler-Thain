// shiftTest.java

package org.jfree.data;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.jfree.data.Range; import org.junit.*;

public class ShiftTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
    	
    }

    @Before
    public void setUp() throws Exception {
    	
    }

    // Test to confirm inputing null parameters throws InvalidParameterException
    @Test(expected = IllegalArgumentException.class)
    public void testNullBase() throws IllegalArgumentException{
		Range.shift(null, 0);
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
	
    @After
    public void tearDown() throws Exception {
		
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	
    }
}
