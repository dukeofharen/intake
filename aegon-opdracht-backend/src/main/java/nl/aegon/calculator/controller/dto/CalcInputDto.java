package nl.aegon.calculator.controller.dto;

import lombok.Builder;
import lombok.Data;

/**
 * A class that is used to receive the calculation input.
 */
@Data
@Builder
public class CalcInputDto {
    private int leftNumber;
    private int rightNumber;
    private String operator;
}
