/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;

/**
 * This is the class for Multiplication Operation extending from BaseOperator. 
 * It overrides the calculate method of BaseOperator class
 * @author poza
 */
public class Multiplication extends BaseOperator{
    
    //NOT USED
    private static final int OPERAND_COUNT = 2;
    
    /**
     * Constructor
     * @param argList - The expression that needs to be evaluated. 
     */
    public Multiplication(String argList) {
        super(argList);
    }
    
    //NOT USED
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    /**
     * This method calculates the product of two operands.
     * First it determines the operands using the parseArguments 
     * method of BaseOperator class and then simply returns the product.
     * @return - integer value
     * @throws CalculatorException 
     */
    @Override
    public int calculate() throws CalculatorException {
        //return product of its arguments
        int operands[] = this.parseArguments(); // determine the operands
        return operands[0] * operands[1];// calculate sum and return
    }
}
