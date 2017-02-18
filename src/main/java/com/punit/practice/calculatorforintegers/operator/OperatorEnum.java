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
    add("org.practice.punit.calculatorforintegers.operator.Addition"), 
    sub("org.practice.punit.calculatorforintegers.operator.Substraction"), 
    mult("org.practice.punit.calculatorforintegers.operator.Multiplication"), 
    div("org.practice.punit.calculatorforintegers.operator.Division"), 
    let("org.practice.punit.calculatorforintegers.operator.Assignment");
    private final String className;
    OperatorEnum(String className) {
        this.className = className;
    }
    public String getClassName() {
        return this.className;
    }
}
