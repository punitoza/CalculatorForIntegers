/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author punit
 */
public class BaseOperatorTest extends TestCase {
    
    public BaseOperatorTest(String testName) {
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
     * Test of createOperator method, of class BaseOperator.
     */
    @Test
    public void testCreateOperator() throws Exception {
        System.out.println("createOperator - add");
        String opName = "add";
        String operatorArgs = "5, 1";
        BaseOperator result = BaseOperator.createOperator(opName, operatorArgs);
        assertTrue(result instanceof Addition && result.argList.equals(operatorArgs));
        
        System.out.println("createOperator - mult");
        opName = "mult";
        operatorArgs = "add(2,2),sub(5,2)";
        result = BaseOperator.createOperator(opName, operatorArgs);
        assertTrue(result instanceof Multiplication && result.argList.equals(operatorArgs));
        
        System.out.println("createOperator - sub");
        opName = "sub";
        operatorArgs = "5, mult(3, add(2, 2))";
        result = BaseOperator.createOperator(opName, operatorArgs);
        assertTrue(result instanceof Substraction && result.argList.equals(operatorArgs));
        
        System.out.println("createOperator - div");
        opName = "div";
        operatorArgs = "sub(14, 2), 6";
        result = BaseOperator.createOperator(opName, operatorArgs);
        assertTrue(result instanceof Division && result.argList.equals(operatorArgs));
        
        System.out.println("createOperator - let");
        opName = "let";
        operatorArgs = "a, add(4,4), mult(5, a)";
        result = BaseOperator.createOperator(opName, operatorArgs);
        assertTrue(result instanceof Assignment && result.argList.equals(operatorArgs));
    }

    /**
     * Test of parseArguments method, of class BaseOperator.
     */
    @Test
    public void testParseArguments() throws Exception {
        System.out.println("parseArguments");
        
        BaseOperator instance = new Addition("5,2");
        int[] result = instance.parseArguments();
        assertEquals(5, result[0]);
        assertEquals(2, result[1]);
        
        instance = new Addition("5,add(2,2)");
        result = instance.parseArguments();
        assertEquals(5, result[0]);
        assertEquals(4, result[1]);
        
        instance = new Addition("mult(2, 3), sub(2,2)");
        result = instance.parseArguments();
        assertEquals(6, result[0]);
        assertEquals(0, result[1]);
        
        instance = new Addition("div(add(2, 8), 2), sub(12, mult(4, 0))");
        result = instance.parseArguments();
        assertEquals(5, result[0]);
        assertEquals(12, result[1]);
        
    }

    public class BaseOperatorImpl extends BaseOperator {

        public BaseOperatorImpl() {
            super("");
        }

        public int calculate() throws CalculatorException {
            return 0;
        }

        public int getOperandCount() {
            return 0;
        }
    }
    
}
