package com.punit.practice.calculatorforintegers.operator;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author punit
 */
public class SubstractionTest extends TestCase {
    
    public SubstractionTest(String testName) {
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
        Substraction instance = new Substraction("2, 3");
        int expResult = -1;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculate method, of class Addition.
     */
    @Test
    public void testCalculate2() throws Exception {
        System.out.println("calculate2");
        Substraction instance = new Substraction("-2, 0");
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
        Substraction instance = new Substraction("-2, -3");
        int expResult = 1;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
}
