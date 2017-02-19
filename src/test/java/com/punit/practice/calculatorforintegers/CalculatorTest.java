/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.util.logging.Level;
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
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute1() throws CalculatorException {
        System.out.println("compute1");
        int result = Calculator.compute("add(1, 2)");
        assertEquals(3, result);
    }
    
    /**
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute2() throws CalculatorException {
        System.out.println("compute2");
        int result = Calculator.compute("add(1, mult(2, 3))");
        assertEquals(7, result);
    }
    
    /**
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute3() throws CalculatorException {
        System.out.println("compute3");
        int result = Calculator.compute("mult(add(2, 2), div(9, 3))");
        assertEquals(12, result);
    }
    
    /**
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute4() throws CalculatorException {
        System.out.println("compute4");
        int result = Calculator.compute("let(a, 5, add(a, a))");
        assertEquals(10, result);
    }
    
    /**
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute5() throws CalculatorException {
        System.out.println("compute5");
        int result = Calculator.compute("let(a, 5, let(b, mult(a, 10), add(b, a)))");
        assertEquals(55, result);
    }
    
    /**
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute6() throws CalculatorException {
        System.out.println("compute6");
        int result = Calculator.compute("let(a, let(b, 10, add(b, b)), let(b, 20, add(a, b)))");
        assertEquals(40, result);
    }
    
    /**
     * Test of main method, of class Calculator.
     */
    @Test
    public void testMain1() {
        System.out.println("main1");
        String[] args = new String[2];
        args[0] = "add(1, 2)";
        args[1] = "error";
        Calculator.main(args);
        assertTrue(Calculator.getLogLevel() == Level.SEVERE);
    }
    
    /**
     * Test of main method, of class Calculator.
     */
    @Test
    public void testMain2() {
        System.out.println("main2");
        String[] args = new String[2];
        args[0] = "add(1, 2)";
        args[1] = "debug";
        Calculator.main(args);
        assertTrue(Calculator.getLogLevel() == Level.FINE);
    }
    
    /**
     * Test of main method, of class Calculator.
     */
    @Test
    public void testMain3() {
        System.out.println("main3");
        String[] args = new String[2];
        args[0] = "add(1, 2)";
        args[1] = "info";
        Calculator.main(args);
        assertTrue(Calculator.getLogLevel() == Level.INFO);
    }
    
}
