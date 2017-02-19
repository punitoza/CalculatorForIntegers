package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author punit
 */
public class DivisionTest extends TestCase {
    
   
    public DivisionTest(String testName) {
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
     * Test of calculate method, of class Division.
     */
    @Test
    public void testCalculate1() throws Exception {
        System.out.println("calculate1");
        Division instance = new Division("6, 3");
        int expResult = 2;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    /**
     * Test of calculate method, of class Division.
     */
    @Test
    public void testCalculate2() throws Exception {
        System.out.println("calculate2");
        Division instance = new Division("-12, -3");
        int expResult = 4;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
        
    
    
    //@Rule public ExpectedException thrown = ExpectedException.none();
    //@Test(expected = IllegalArgumentException.class)
    public void testCalculate3() throws CalculatorException{
        System.out.println("calculate3");
        Division instance = new Division("-2, 0");
        //thrown.expect(RuntimeException.class);
        //thrown.expectMessage(Division.DIVISOR_ZERO_ERROR);
        String message = null;
        try {
            instance.calculate();
        } catch(Exception ex) {
            message = ex.getMessage();
        }
        assertEquals(Division.DIVISOR_ZERO_ERROR, message);
    }
    
}
