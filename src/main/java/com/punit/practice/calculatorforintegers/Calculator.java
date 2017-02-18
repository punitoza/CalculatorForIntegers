package com.punit.practice.calculatorforintegers;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import com.punit.practice.calculatorforintegers.operator.BaseOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class Calculator is the main Application class. It contains the main method to run this program.
 * It contains the compute method which returns the result of the computation for the input expression string
 * @author punit
 */
public class Calculator {
    
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());
    /**
     * This method takes in the input expression as the parameter and computes the result after solving the expression
     * @param expr - input expression string
     * @return - integer value which is the calculated value for the input expression string 
     * @throws CalculatorException 
     */
    public static int compute(String expr) throws CalculatorException {
        LOGGER.fine("Inside compute method. expr value: " + expr);
        LOGGER.info("Starting computation...");
        expr = expr.trim();
        String operatorStr = expr.substring(0, expr.indexOf('(')); //Get the Operator name
        LOGGER.fine("***************************");
        LOGGER.fine("Operator: " + operatorStr);
        String operatorArgs = expr.substring(expr.indexOf('(') + 1, expr.lastIndexOf(')')); // Get the Operator arguments
        LOGGER.fine("Operator Arguments: " + operatorArgs);
        int result = BaseOperator.createOperator(operatorStr, operatorArgs).calculate();
        LOGGER.fine("Result: " + result);
        LOGGER.fine("***************************");
        return result;
    }
    /**
     * Main method to invoke the Calculator program. 
     * @param args 
     * Takes one string as the parameter which is the input expression
     * Also supports command line option -d logLevel which determines the verbosity for the logs of the application.
     * The default log level is INFO. Other values supported are ERROR and DEBUG.
     */
    public static void main(String args[]) {
        try {
            //int result = compute(args[0]);
            int result = compute("let(add(, 5, add(a, sub(13, let(b, 3, add(2, b)))))");
            System.out.println(result); //Print the output
        } catch (CalculatorException ex) {
            LOGGER.severe(ex.getMessage());
            if(LOGGER.getLevel() == Level.FINE) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * This method logs the messages from other classes using its Logger instance. 
     * The other classes do not need to maintain the Logger instance in their own classes.
     * @param level
     * @param message 
     */
    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }
}
