/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.operator;

import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author punit
 */
public class AssignmentTest {
    
    public AssignmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class Assignment.
     */
    @Test
    public void testCalculate() throws Exception {
        System.out.println("calculate");
        Assignment instance = new Assignment("a, 5, add(a, 3)");
        int expResult = 8;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }

    /**
     * Test of parseArguments method, of class Assignment.
     */
    @Test
    public void testParseArguments1() throws Exception {
        System.out.println("parseArguments1");
        BaseOperator instance = new Assignment("v, 6, sub(v, let(c, 5, add(2, c)))");
        int[] result = instance.parseArguments();
        assertEquals(-1, result[0]);
    }
    
    @Test
    public void testParseArguments2() throws Exception {
        System.out.println("parseArguments2");
        BaseOperator instance = new Assignment("v, add(5, mult(div(21, 3), 2)), sub(v, let(c, 5, add(2, c)))");
        int[] result = instance.parseArguments();
        assertEquals(12, result[0]);
    }
    
    @Test
    public void testParseArguments3() throws Exception {
        System.out.println("parseArguments3");
        BaseOperator instance = new Assignment("var, 5, add(2,2)");
        int[] result = instance.parseArguments();
        assertEquals(4, result[0]);
    }
    
    
}
