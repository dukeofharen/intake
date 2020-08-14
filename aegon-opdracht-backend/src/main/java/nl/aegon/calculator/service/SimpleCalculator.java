package nl.aegon.calculator.service;

import org.springframework.stereotype.Service;

/**
 * A class that is used to execute several types of calculations.
 */
@Service
public class SimpleCalculator {
    /**
     * Performs an add.
     * @param leftNumber The left number.
     * @param rightNumber The right number.
     * @return The calculated result
     */
    public double add(int leftNumber, int rightNumber) {
        return leftNumber + rightNumber;
    }

    /**
     * Performs a subtract.
     * @param leftNumber The left number.
     * @param rightNumber The right number.
     * @return The calculated result
     */
    public double subtract(int leftNumber, int rightNumber) {
        return leftNumber - rightNumber;
    }

    /**
     * Performs a multiplication.
     * @param leftNumber The left number.
     * @param rightNumber The right number.
     * @return The calculated result
     */
    public double multiply(int leftNumber, int rightNumber) {
        return leftNumber * rightNumber;
    }

    /**
     * Performs a division.
     * @param leftNumber The left number.
     * @param rightNumber The right number.
     * @return The calculated result
     */
    public double divide(int leftNumber, int rightNumber) {
        if (rightNumber == 0) {
            throw new IllegalStateException("Can't divide by zero");
        }

        return (double) leftNumber / (double) rightNumber;
    }
}
