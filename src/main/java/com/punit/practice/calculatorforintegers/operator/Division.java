package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;

/**
 * This is the class for Division Operation extending from BaseOperator. 
 * It overrides the calculate method of BaseOperator class
 * @author poza
 */
public class Division extends BaseOperator{
    //NOT USED
    private static final int OPERAND_COUNT = 2;
    public static final String DIVISOR_ZERO_ERROR = "Encountered zero as the divisor";
    /**
     * Constructor
     * @param argList - The expression that needs to be evaluated 
     */
    public Division(String argList) {
        super(argList);
    }
    
    //NOT USED
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    /**
     * This method calculates the division of first operand by second operand.
     * First it determines the operands using the parseArguments 
     * method of BaseOperator class and then simply returns the division result.
     * @return - integer value
     * @throws CalculatorException 
     */
    @Override
    public int calculate() throws CalculatorException {
        //return division of its arguments
        int operands[] = this.parseArguments(); // determine the operands
        if(operands[1] == 0) { // if divsior is 0 then throw an exception
            throw new IllegalArgumentException(DIVISOR_ZERO_ERROR);
        } else {
            return operands[0] / operands[1]; // calculate sum and return
        }
    }
}
