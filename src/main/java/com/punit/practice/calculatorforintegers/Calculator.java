/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;

/**
 *
 * @author punit
 */
public class Calculator {
    public static int compute(String expr) throws CalculatorException {
        return 0;
    }
    public static void main(String args[]) {
        try {
            int result = compute(args[0]);
            System.out.println(result);
        } catch (CalculatorException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
