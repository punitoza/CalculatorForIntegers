/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;

/**
 *
 * @author poza
 */
public class Substraction extends BaseOperator{
    private static final int OPERAND_COUNT = 2;
    public Substraction(String argList) {
        super(argList);
    }
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    @Override
    public int calculate() throws CalculatorException {
        //return difference of its arguments
        int operands[] = this.parseArguments();
        return operands[0] - operands[1];
    }
}
