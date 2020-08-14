package nl.aegon.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTests {
    @Mock
    private SimpleCalculator simpleCalculatorMock;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    public void calculateAddShouldCallAdd() {
        // Arrange
        int left = 10;
        int right = 15;
        double expected = 25;
        String operator = "+";

        when(simpleCalculatorMock.add(left, right)).thenReturn(expected);

        // Act
        double result = calculatorService.calculate(left, right, operator);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).add(left, right);
    }

    @Test
    public void calculateSubtractShouldCallSubtract() {
        // Arrange
        int left = 15;
        int right = 5;
        double expected = 10;
        String operator = "-";

        when(simpleCalculatorMock.subtract(left, right)).thenReturn(expected);

        // Act
        double result = calculatorService.calculate(left, right, operator);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).subtract(left, right);
    }

    @Test
    public void calculateMultiplyShouldCallMultiply() {
        // Arrange
        int left = 15;
        int right = 5;
        double expected = 45;
        String operator = "*";

        when(simpleCalculatorMock.multiply(left, right)).thenReturn(expected);

        // Act
        double result = calculatorService.calculate(left, right, operator);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).multiply(left, right);
    }

    @Test
    public void calculateDivideShouldCallDivide() {
        // Arrange
        int left = 15;
        int right = 5;
        double expected = 3;
        String operator = "/";

        when(simpleCalculatorMock.divide(left, right)).thenReturn(expected);

        // Act
        double result = calculatorService.calculate(left, right, operator);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).divide(left, right);
    }

    @Test
    public void calculateUnknownOperatorShouldThrowIllegalStateException() {
        // Arrange
        int left = 15;
        int right = 5;
        String operator = "%";

        // Act / Assert
        assertThrows(IllegalStateException.class, () -> calculatorService.calculate(left, right, operator));

    }
}
