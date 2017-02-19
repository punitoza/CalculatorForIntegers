package com.punit.practice.calculatorforintegers.operator;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author punit
 */
public class MultiplicationTest extends TestCase {
    
    public MultiplicationTest(String testName) {
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
     * Test of calculate method, of class Multiplication.
     */
    @Test
    public void testCalculate1() throws Exception {
        System.out.println("calculate1");
        Multiplication instance = new Multiplication("2, 3");
        int expResult = 6;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculate method, of class Multiplication.
     */
    @Test
    public void testCalculate2() throws Exception {
        System.out.println("calculate2");
        Multiplication instance = new Multiplication("-2, 0");
        int expResult = 0;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculate method, of class Multiplication.
     */
    @Test
    public void testCalculate3() throws Exception {
        System.out.println("calculate3");
        Multiplication instance = new Multiplication("-2, -3");
        int expResult = 6;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
}
