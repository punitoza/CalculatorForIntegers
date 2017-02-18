/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import com.punit.practice.calculatorforintegers.operator.BaseOperator;

/**
 *
 * @author punit
 */
public class Calculator {
    public static int compute(String expr) throws CalculatorException {
        expr = expr.trim();
        String operatorStr = expr.substring(0, expr.indexOf('('));
        String operatorArgs = expr.substring(expr.indexOf('(') + 1, expr.lastIndexOf(')'));
        return BaseOperator.createOperator(operatorStr, operatorArgs).calculate();
    }
    public static void main(String args[]) {
        try {
            //int result = compute(args[0]);
            int result = compute("let(add(, 5, add(a, sub(13, let(b, 3, add(2, b)))))");
            System.out.println(result);
        } catch (CalculatorException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
