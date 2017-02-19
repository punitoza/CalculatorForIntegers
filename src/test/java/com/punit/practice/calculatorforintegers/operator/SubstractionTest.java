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
    public void testCalculate() throws Exception {
        System.out.println("calculate");
        Substraction instance = new Substraction("2, 3");
        int expResult = -1;
        int result = instance.calculate();
        assertEquals(expResult, result);
        
        System.out.println("calculate");
        instance = new Substraction("-2, 0");
        expResult = -2;
        result = instance.calculate();
        assertEquals(expResult, result);
        
        System.out.println("calculate");
        instance = new Substraction("-2, -3");
        expResult = 1;
        result = instance.calculate();
        assertEquals(expResult, result);
    }
    
}
