package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;

/**
 * This is the class for Subtraction Operation extending from BaseOperator. 
 * It overrides the calculate method of BaseOperator class
 * @author poza
 */
public class Substraction extends BaseOperator{
    
    //NOT USED
    private static final int OPERAND_COUNT = 2;
    
    /**
     * Constructor
     * @param argList - The expression that needs to be evaluated 
     */
    public Substraction(String argList) {
        super(argList);
    }
    
    //NOT USED
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    /**
     * This method calculates the difference between two operands (subtracts second operand from the first).
     * First it determines the operands using the parseArguments 
     * method of BaseOperator class and then simply returns the difference.
     * @return - integer value
     * @throws CalculatorException 
     */
    @Override
    public int calculate() throws CalculatorException {
        //return difference of its arguments
        int operands[] = this.parseArguments(); // determine the operands
        return operands[0] - operands[1];// calculate sum and return
    }
}
