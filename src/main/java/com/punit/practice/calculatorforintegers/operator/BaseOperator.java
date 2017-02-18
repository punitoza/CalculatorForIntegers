/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;

/**
 *
 * @author punit
 */
public abstract class BaseOperator {
    protected final String argList;

    protected BaseOperator(String argList) {
        this.argList = argList.trim();
    }
    
    public abstract int calculate() throws CalculatorException;
    protected abstract int getOperandCount();
    protected abstract int[] parseArguments() throws CalculatorException;
}
