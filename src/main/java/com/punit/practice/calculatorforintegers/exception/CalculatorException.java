/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.punit.practice.calculatorforintegers.exception;

/**
 *
 * @author punit
 */
public class CalculatorException extends Exception {
    public CalculatorException(Throwable ex) {
        super(ex);
    }
    public String toString() {
        return "CalculatorException";
    }
}
