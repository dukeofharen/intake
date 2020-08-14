package nl.aegon.calculator.service;

import org.springframework.stereotype.Service;

/**
 * A class that accepts a calculation as input and calls the SimpleCalculator class accordingly.
 */
@Service
public class CalculatorService {
    private final SimpleCalculator simpleCalculator;

    public CalculatorService(SimpleCalculator simpleCalculator) {
        this.simpleCalculator = simpleCalculator;
    }

    /**
     * A method for calculating the result.
     * @param leftNumber The left number.
     * @param rightNumber The right number.
     * @param operator The operator which should be used.
     * @return The calculated result.
     */
    public double calculate(int leftNumber, int rightNumber, String operator) {
        switch (operator) {
            case "+":
                return simpleCalculator.add(leftNumber, rightNumber);
            case "-":
                return simpleCalculator.subtract(leftNumber, rightNumber);
            case "*":
                return simpleCalculator.multiply(leftNumber, rightNumber);
            case "/":
                return simpleCalculator.divide(leftNumber, rightNumber);
            default:
                // Unexpected operator provided
                throw new IllegalStateException(String.format("Operator %s not supported!", operator));
        }
    }
}
