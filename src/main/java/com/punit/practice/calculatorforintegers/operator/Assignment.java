/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.Calculator;
import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.util.regex.Pattern;

/**
 *
 * @author poza
 */
public class Assignment extends BaseOperator{
    private static final int OPERAND_COUNT = 2;
    public Assignment(String argList) {
        super(argList);
    }
    protected int getOperandCount() {
        return OPERAND_COUNT;
    }
    @Override
    public int calculate() throws CalculatorException {
        //return sum of its arguments
        int operands[] = this.parseArguments();
        return operands[0];
    }
    
    @Override
    protected int[] parseArguments() throws CalculatorException {
        String varName = argList.substring(0, argList.indexOf(','));
        Pattern intsOnly = Pattern.compile("\\d+");
        if(intsOnly.matcher(varName).matches()) {
            throw new IllegalArgumentException("Cannot have integer as the let operator variable.");
        }
        if(varName.contains("(") || varName.contains(")")) {
            throw new IllegalArgumentException("Cannot have brackets in the let operator variable.");
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
        if(intsOnly.matcher(valueStr).matches()) {
            value = Integer.parseInt(valueStr);
        } else {
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
                valueStr = valueStr.substring(0, i);
                value = Calculator.compute(valueStr.trim());
                endIndex = i;
            }
        }
        String expr = argList.substring(endIndex+1, argList.length()).trim();
        if(intsOnly.matcher(expr).matches()) {
            throw new IllegalArgumentException("Cannot have integer as the let operator expression.");
        }
        expr = expr.replaceAll("\\(" + varName + ",", "(" + value + ",");
        expr = expr.replaceAll(",\\s*" + varName + "\\)", "," + value + ")");
        int operand[] = new int[1];
        operand[0] = Calculator.compute(expr.trim());
        return operand;
    }
}
