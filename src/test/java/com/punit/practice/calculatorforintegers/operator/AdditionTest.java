package com.punit.practice.calculatorforintegers.operator;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author punit
 */
public class AdditionTest extends TestCase {
    
    public AdditionTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of calculate method, of class Addition.
     */
    @Test
    public void testCalculate1() throws Exception {
        System.out.println("calculate1");
        Addition instance = new Addition("2, 3");
        int expResult = 5;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculate method, of class Addition.
     */
    @Test
    public void testCalculate2() throws Exception {
        System.out.println("calculate2");
        
        Addition instance = new Addition("-2, 0");
        int expResult = -2;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculate method, of class Addition.
     */
    @Test
    public void testCalculate3() throws Exception {
        System.out.println("calculate3");
        
        Addition instance = new Addition("-2, -3");
        int expResult = -5;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
}
