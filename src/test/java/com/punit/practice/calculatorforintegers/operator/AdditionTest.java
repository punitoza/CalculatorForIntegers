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
    public void testCalculate() throws Exception {
        System.out.println("calculate");
        Addition instance = new Addition("2, 3");
        int expResult = 5;
        int result = instance.calculate();
        assertEquals(expResult, result);
        
        System.out.println("calculate");
        instance = new Addition("-2, 0");
        expResult = -2;
        result = instance.calculate();
        assertEquals(expResult, result);
        
        System.out.println("calculate");
        instance = new Addition("-2, -3");
        expResult = -5;
        result = instance.calculate();
        assertEquals(expResult, result);
    }
    
}
