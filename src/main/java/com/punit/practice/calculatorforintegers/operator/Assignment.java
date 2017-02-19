package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.Calculator;
import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.util.logging.Level;
import java.util.regex.Pattern;

/**
 * This is the class for Assignment Operation extending from BaseOperator. 
 * It overrides the calculate method of BaseOperator class and also provides
 * its own implementation of parseArguments method because this operator works
 * with three operands as opposed to default of two.
 * @author poza
 */
public class Assignment extends BaseOperator{
    
    //NOT USED
    private static final int OPERAND_COUNT = 3;
    
    /**
     * Constructor
     * @param argList - The expression that needs to be evaluated
     */
    public Assignment(String argList) {
        super(argList);
    }
    
    //NOT USED
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    /**
     * This method calculates the value of third expression after assigning 
     * the value of second expression to the string variable name specified in 
     * the first expression. Thus it works with three operands separated by comma
     * @return
     * @throws CalculatorException 
     */
    @Override
    public int calculate() throws CalculatorException {
        //return the caluclated value of third expression(operand) based on the value assigned to the variable name
        //supplied in the first expression(operand)
        int operands[] = this.parseArguments();
        return operands[0];
    }
    
    @Override
    protected int[] parseArguments() throws CalculatorException {
        Calculator.log(Level.INFO, "Parsing arguments: " + argList);
        String varName = argList.substring(0, argList.indexOf(','));
        //Make sure that first operand is valid variable name and not conflicting with operator names.
        Pattern intsOnly = Pattern.compile("\\d+|-\\d+");
        Pattern variableNamePattern = Pattern.compile("[a-zA-Z]+");
        if(!variableNamePattern.matcher(varName).matches()) {
            throw new IllegalArgumentException("Cannot have characters other than a-z and A-Z for the let operator variable.");
        }
        for(OperatorEnum str: OperatorEnum.values()) {
            if(str.toString().equalsIgnoreCase(varName.trim())) {
                throw new IllegalArgumentException("Cannot have operator name - "  + str + " as the let operator variable.");
            }
        }
        int value;
        int startIndex = argList.indexOf(',')+1;
        int endIndex = argList.indexOf(",", startIndex);
        String valueStr = argList.substring(startIndex, endIndex).trim();
        //If the assignment value is an integer use that else parse the expression and compute it
        if(intsOnly.matcher(valueStr).matches()) {
            value = Integer.parseInt(valueStr);
            Calculator.log(Level.FINE, "Assignment value: " + value);
            valueStr = argList;
        } else {
            valueStr = argList.substring(startIndex, argList.length());
            int bracketIndex = valueStr.indexOf('(');
            int count, i;
            for(count=1, i=bracketIndex+1;count != 0 && i < valueStr.length();i++) {
                if(valueStr.charAt(i) == '('){
                    count++;
                } else if(valueStr.charAt(i) == ')') {
                    count--;
                }
            }
            if(count != 0 || valueStr.charAt(i) != ',') {
                throw new IllegalArgumentException("Incorrect format of the assignment value for the let operator.");
            } else {
                // Compute the value that needs to be assigned to the variable
                String vStr = valueStr.substring(0, i);
                value = Calculator.compute(vStr.trim());
                Calculator.log(Level.FINE, "Assignment expression: " + valueStr + "--- value: " + value);
                endIndex = i;
            }
        }
        //Determin the value that needs to be assigned to the variable specified in the first operand.
        String expr = valueStr.substring(endIndex+1, valueStr.length()).trim();
        if(intsOnly.matcher(expr).matches()) {
            throw new IllegalArgumentException("Cannot have integer as the let operator expression.");
        }
        //Remove the space and replace the variable name with the value
        expr = expr.replaceAll("\\(" + varName + ",", "(" + value + ",");
        expr = expr.replaceAll(",\\s*" + varName + "\\)", "," + value + ")");
        //Now compute the value of the third expression (operand) 
        int operand[] = new int[1];
        operand[0] = Calculator.compute(expr.trim());
        return operand;
    }
}
