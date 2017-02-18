/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.lang.reflect.Constructor;

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
    protected abstract int[] parseArguments() throws CalculatorException;
}
