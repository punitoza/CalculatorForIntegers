/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.Calculator;
import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.lang.reflect.Constructor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author punit
 */
public abstract class BaseOperator {
    public static BaseOperator createOperator(String opName, String operatorArgs) throws CalculatorException {
        try {
            opName = opName.toLowerCase();
            OperatorEnum opEnum = OperatorEnum.valueOf(opName);
            Class cls;
            cls = Class.forName(opEnum.getClassName());
            Class argClass[] = new Class[1];
            argClass[0] = String.class;
            Constructor<BaseOperator> ct = cls.getConstructor(argClass);
            Object argList[] = new Object[1];
            argList[0] = operatorArgs;
            return ct.newInstance(argList);
        } catch (Exception ex) {
            throw new CalculatorException(ex);
        }
    }
    protected final String argList;

    protected BaseOperator(String argList) {
        this.argList = argList.trim();
    }
    
    public abstract int calculate() throws CalculatorException;
    protected abstract int getOperandCount();
    protected int[] parseArguments() throws CalculatorException {
        try {
            if(this.getOperandCount() != 2) {
                throw new IllegalArgumentException("Wrong Parsing method chosen.");
            }
            int operands[] = new int[this.getOperandCount()];
            Pattern intsOnly = Pattern.compile("\\d+");
            Matcher matcher;
            String temp = argList.substring(0, argList.indexOf(','));
            String strArr[] = new String[2];
            if(intsOnly.matcher(temp).matches()) {
                strArr = argList.split(",", 2);
            } else {
                int bracketIndex = argList.indexOf('(');
                int count, i;
                for(count=1, i=bracketIndex+1;count != 0 && i < argList.length();i++) {
                    if(argList.charAt(i) == '('){
                        count++;
                    } else if(argList.charAt(i) == ')') {
                        count--;
                    }
                }
                if(count != 0 || argList.charAt(i) != ',') {
                    throw new IllegalArgumentException("Incorrect format");
                } else {
                    strArr[0] = argList.substring(0, i);
                    strArr[1] = argList.substring(i+1, argList.length());
                }
            }
            int i = 0;
            for(String str: strArr) {
                matcher = intsOnly.matcher(str.trim());
                if(matcher.matches()) {
                    operands[i++] = Integer.parseInt(str.trim());
                } else {
                    operands[i++] = Calculator.compute(str.trim());
                }
            }
            return operands;
        } catch(Throwable ex) {
            throw new CalculatorException(ex);
        }
    }
}
