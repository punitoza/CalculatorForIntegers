package com.punit.practice.calculatorforintegers.operator;

import com.punit.practice.calculatorforintegers.Calculator;
import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is the base class for all operators supported by Calculator program.
 * It provides a factory method to create the instance of the class depending on the 
 * operator operator name.
 * 
 * It also declares a String named "argList" as the instance variable which gets 
 * inherited to all sub classes. The argList is the expression that needs to be 
 * evaluated. 
 * 
 * It also declares an abstract method called "calculate" that needs to be 
 * overridden by implementing classes. It is a contract to calculate and provide
 * the result of the expression which needs to be followed by all sub classes.
 * 
 * It provides a default implementation of the parseArguments method that parses
 * the expression on the assumption that there will be two operands at one level.
 * Since most of the operators use two operands, this method is used by all those
 * sub classes. For classes that require more or less than two operands, th
 * parseArguments method needs to be overridden.
 * 
 * @author punit
 */
public abstract class BaseOperator {
    
    /**
     * This is a factory method for creating instances of Operator classes depending on the operand. 
     * This method uses Java Reflection API to create operator instances so that new Operators can be 
     * added quickly - just by modifying the OperatorEnum class and by adding the sub class for the 
     * Operator. No if or switch case is required to be modified.
     * 
     * @param opName
     * @param operatorArgs
     * @return
     * @throws CalculatorException 
     */
    public static BaseOperator createOperator(String opName, String operatorArgs) throws CalculatorException {
        try {
            opName = opName.toLowerCase(); //Support case in-sensitive operators
            OperatorEnum opEnum = OperatorEnum.valueOf(opName); // Get the Operator enum corresponding to the operation Name
            Class cls;
            cls = Class.forName(opEnum.getClassName()); // Get the class object for the Operator class required
            Class argClass[] = new Class[1];
            argClass[0] = String.class;
            Constructor<BaseOperator> ct = cls.getConstructor(argClass); // Get the contructor object
            Object argList[] = new Object[1];
            argList[0] = operatorArgs;
            return ct.newInstance(argList); // Invoke the constructor to create the new instane dynamically.
        } catch (Exception ex) {
            throw new CalculatorException(ex);
        }
    }
    
    /**
     * The expression that needs to be evaluated.
     */
    protected final String argList;

    /**
     * Constructor
     * @param argList - The expression that needs to be evaluated.
     */
    protected BaseOperator(String argList) {
        this.argList = argList.trim();
    }
    
    /**
     * This method calculates the result of out of the expression. But each 
     * implementing class will have its own implementation for this method.
     * @return
     * @throws CalculatorException 
     */
    public abstract int calculate() throws CalculatorException;
    
    protected abstract int getOperandCount();
    
    /**
     * This method provides a default implementation of the parseArguments method that parses
     * the expression on the assumption that there will be two operands at one level.
     * Since most of the operators use two operands, this method is used by all those
     * sub classes. For classes that require more or less than two operands, th
     * parseArguments method needs to be overridden. 
     * @return
     * @throws CalculatorException 
     */
    protected int[] parseArguments() throws CalculatorException {
        Calculator.log(Level.INFO, "Parsing arguments: " + argList);
        try {
            if(this.getOperandCount() != 2) { // This method works only for operators having two operands.
                throw new IllegalArgumentException("Wrong Parsing method chosen.");
            }
            int operands[] = new int[this.getOperandCount()];
            Pattern intsOnly = Pattern.compile("\\d+|-\\d+");
            Matcher matcher;
            String temp = argList.substring(0, argList.indexOf(','));
            String strArr[] = new String[2];
            if(intsOnly.matcher(temp).matches()) { // If the string is an Integer, then that becomes the first operand
                strArr = argList.split(",", 2);
            } else { // there is a nested operation
                int bracketIndex = argList.indexOf('(');
                int count, i;
                // Search for the complete operation by keeping track of opening and closing brackets.
                for(count=1, i=bracketIndex+1;count != 0 && i < argList.length();i++) {
                    if(argList.charAt(i) == '('){
                        count++;
                    } else if(argList.charAt(i) == ')') {
                        count--;
                    }
                }
                if(count != 0 || argList.charAt(i) != ',') {
                    throw new IllegalArgumentException("Incorrect format, expected comma, found: " + argList.charAt(i));
                } else {
                    strArr[0] = argList.substring(0, i); // Found the logical sub expression
                    strArr[1] = argList.substring(i+1, argList.length()); // Found the second logical sub expression
                }
            }
            int i = 0;
            int opValue;
            for(String str: strArr) {
                matcher = intsOnly.matcher(str.trim());
                if(matcher.matches()) {
                    opValue = Integer.parseInt(str.trim()); // Found first opearand
                    operands[i++] = opValue;
                } else {
                    opValue = Calculator.compute(str.trim()); //Second operand is not an integer, hence it need to compute the nested expression
                    operands[i++] = opValue;
                }
                Calculator.log(Level.FINE, "Expression: " + str + "--- Operand: " + opValue);
            }
            return operands;
        } catch(Throwable ex) {
            throw new CalculatorException(ex);
        }
    }
}
