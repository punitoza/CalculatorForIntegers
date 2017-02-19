package com.punit.practice.calculatorforintegers;

import com.punit.practice.calculatorforintegers.exception.CalculatorException;
import com.punit.practice.calculatorforintegers.operator.BaseOperator;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
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
            //If the expression is not passed as command line argument, then raise the exception and return.
            if(args == null || args.length < 1 || args[0].length() < 1) {
                throw new IllegalArgumentException("No expression found to evaluate.");
            }
            //If the optional logging level parameter is passed, then capture it and set the logging level.
            if(args.length > 1) {
                String level = args[1];
                if(level.equalsIgnoreCase("debug")) {
                    Calculator.LOGGER.setLevel(Level.FINE);
                } else if (level.equalsIgnoreCase("error")) {
                    Calculator.LOGGER.setLevel(Level.SEVERE);
                } else if(level.equalsIgnoreCase("off")) {
                    Calculator.LOGGER.setLevel(Level.OFF);
                } else {
                    Calculator.LOGGER.setLevel(Level.INFO);
                }
                Logger log = LogManager.getLogManager().getLogger("");
                for (Handler h : log.getHandlers()) {
                    h.setLevel(Calculator.LOGGER.getLevel());
                }
            }
            //Compute the result of the expression.
            int result = compute(args[0]);
            System.out.println(result); //Print the output
        } catch (CalculatorException ex) {
            System.out.println("Error occurred while calculating.");
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
    
    public static Level getLogLevel() {
        return LOGGER.getLevel();
    }
}
