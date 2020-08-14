package nl.aegon.calculator.controller;

import nl.aegon.calculator.controller.dto.CalcInputDto;
import nl.aegon.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller which accepts the calculations.
 */
@RestController
@CrossOrigin(origins = "*")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * An endpoint which accepts a single calculation.
     * @param input The calculation input.
     * @return the calculation result.
     */
    @PostMapping("/api/calculator/single")
    public ResponseEntity<Double> calculateSingle(@RequestBody CalcInputDto input) {
        Double result = calculatorService.calculate(input.getLeftNumber(), input.getRightNumber(), input.getOperator());
        return ResponseEntity.ok(result);
    }

    /**
     * An endpoint which accepts multiple calculations.
     * @param inputList A list with calculation inputs.
     * @return the calculation result list.
     */
    @PostMapping("/api/calculator/multiple")
    public ResponseEntity<List<Double>> calculateMultiple(@RequestBody List<CalcInputDto> inputList) {
        List<Double> result = new ArrayList<>();
        for (CalcInputDto input : inputList) {
            result.add(calculatorService.calculate(input.getLeftNumber(), input.getRightNumber(), input.getOperator()));
        }

        return ResponseEntity.ok(result);
    }
}
