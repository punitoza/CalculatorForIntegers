/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punit.practice.calculatorforintegers.operator;

/**
 *
 * @author poza
 */
public enum OperatorEnum {
    add("com.punit.practice.calculatorforintegers.operator.Addition"), 
    sub("com.punit.practice.calculatorforintegers.operator.Substraction"), 
    mult("com.punit.practice.calculatorforintegers.operator.Multiplication"), 
    div("com.punit.practice.calculatorforintegers.operator.Division"), 
    let("com.punit.practice.calculatorforintegers.operator.Assignment");
    private final String className;
    OperatorEnum(String className) {
        this.className = className;
    }
    public String getClassName() {
        return this.className;
    }
}
