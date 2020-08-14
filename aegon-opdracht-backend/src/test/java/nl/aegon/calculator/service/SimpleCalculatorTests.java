package nl.aegon.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SimpleCalculatorTests {
    private final SimpleCalculator calculator = new SimpleCalculator();

    @Test
    public void addShouldReturnCorrectResult() {
        double result = calculator.add(10, 15);
        assertEquals(25, result);
    }

    @Test
    public void subtractPositiveShouldReturnCorrectResult() {
        double result = calculator.subtract(15, 10);
        assertEquals(5, result);
    }

    @Test
    public void subtractNegativeShouldReturnCorrectResult() {
        double result = calculator.subtract(10, 15);
        assertEquals(-5, result);
    }

    @Test
    public void multiplyShouldReturnCorrectResult() {
        double result = calculator.multiply(2, 8);
        assertEquals(16, result);
    }

    @Test
    public void divideSimpleShouldReturnCorrectResult() {
        double result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void divideComplexShouldReturnCorrectResult() {
        double result = calculator.divide(10, 4);
        assertEquals(2.5, result);
    }

    @Test
    public void divideByZeroShouldThrowIllegalStateException() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> calculator.divide(10, 0));
        assertEquals("Can't divide by zero", exception.getMessage());
    }
}
