package com.punit.practice.calculatorforintegers.operator;

/**
 * This class contains all the operators supported by the Calculator Program. 
 * It maps the expression for an operation from the string to the corresponding 
 * Java class which will carryout the desired operation.
 * @author poza
 */
public enum OperatorEnum {
    /**
     * Declaration of all Operator Enum classes and initialization with their respective
     * class names.
     */
    add("com.punit.practice.calculatorforintegers.operator.Addition"), 
    sub("com.punit.practice.calculatorforintegers.operator.Substraction"), 
    mult("com.punit.practice.calculatorforintegers.operator.Multiplication"), 
    div("com.punit.practice.calculatorforintegers.operator.Division"), 
    let("com.punit.practice.calculatorforintegers.operator.Assignment");
    
    /**
     * The name of the class that must be instantiated to carry out the operation
     */
    private final String className;
    
    /**
     * Constructor
     * @param className 
     */
    OperatorEnum(String className) {
        this.className = className;
    }
    
    /**
     * Getter method
     * @return Class Name associated with this Operator Enum
     */
    public String getClassName() {
        return this.className;
    }
}
