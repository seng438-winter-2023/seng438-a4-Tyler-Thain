package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class GetLowerBoundTest {
	private Range getlowerbound1;
	private Range getlowerbound2;
	private Range getlowerbound3;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


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

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
