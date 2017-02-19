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
    public void testCalculate() throws Exception {
        System.out.println("calculate");
        Multiplication instance = new Multiplication("2, 3");
        int expResult = 6;
        int result = instance.calculate();
        assertEquals(expResult, result);
        
        System.out.println("calculate");
        instance = new Multiplication("-2, 0");
        expResult = 0;
        result = instance.calculate();
        assertEquals(expResult, result);
        
        System.out.println("calculate");
        instance = new Multiplication("-2, -3");
        expResult = 6;
        result = instance.calculate();
        assertEquals(expResult, result);
    }
    
}
