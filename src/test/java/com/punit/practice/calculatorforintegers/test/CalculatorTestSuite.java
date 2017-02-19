/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.test;

import com.punit.practice.calculatorforintegers.CalculatorTest;
import com.punit.practice.calculatorforintegers.operator.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author punit
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, AdditionTest.class, AssignmentTest.class, BaseOperatorTest.class, DivisionTest.class, MultiplicationTest.class, SubstractionTest.class})
public class CalculatorTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
