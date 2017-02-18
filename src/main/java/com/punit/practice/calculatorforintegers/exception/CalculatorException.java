package com.punit.practice.calculatorforintegers.exception;

/**
 * This class is the main Exception class for Calculator Program.
 * It is a wrapper for all exceptions occurred during this program.
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
