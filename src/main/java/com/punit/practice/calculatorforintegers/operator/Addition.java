package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.Calculator;
import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.util.logging.Level;

/**
 * This is the class for Addition Operation extending from BaseOperator. 
 * It overrides the calculate method of BaseOperator class
 * @author poza
 */
public class Addition extends BaseOperator{
    
    //NOT USED
    private static final int OPERAND_COUNT = 2;
    
    /**
     * Constructor
     * @param argList - The expression that needs to be evaluated 
     */
    public Addition(String argList) {
        super(argList);
    }
    
    //NOT USED
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    /**
     * This method calculates the sum of two operands.
     * First it determines the operands using the parseArguments 
     * method of BaseOperator class and then simply returns the sum.
     * @return - integer value
     * @throws CalculatorException 
     */
    @Override
    public int calculate() throws CalculatorException {
        //return sum of its arguments
        int operands[] = this.parseArguments(); // determine the operands
        return operands[0] + operands[1]; // calculate sum and return
    }
}
