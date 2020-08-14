package nl.aegon.calculator.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.aegon.calculator.controller.dto.CalcInputDto;
import nl.aegon.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CalculatorControllerTests {
    @MockBean
    private CalculatorService calculatorServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateSingleShouldCallCalculatorServiceCorrectly() throws Exception {
        // Arrange
        CalcInputDto input = CalcInputDto.builder().leftNumber(10).rightNumber(15).operator("+").build();
        double expectedResult = 25;
        when(calculatorServiceMock.calculate(input.getLeftNumber(), input.getRightNumber(), input.getOperator())).thenReturn(expectedResult);

        // Act
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/calculator/single")
                        .content(asJsonString(input))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expectedResult));

        // Assert
        verify(calculatorServiceMock).calculate(anyInt(), anyInt(), any());
    }

    @Test
    public void calculateMultipleShouldCallCalculatorServiceCorrectly() throws Exception {
        // Arrange
        List<CalcInputDto> input = new ArrayList<>();
        input.add(CalcInputDto.builder().leftNumber(10).rightNumber(11).operator("+").build());
        input.add(CalcInputDto.builder().leftNumber(343).rightNumber(65).operator("-").build());
        input.add(CalcInputDto.builder().leftNumber(21).rightNumber(556).operator("*").build());
        double expectedResult = 25;
        when(calculatorServiceMock.calculate(anyInt(), anyInt(), any())).thenReturn(expectedResult);

        // Act
        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/calculator/multiple")
                        .content(asJsonString(input))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        ObjectMapper mapper = new ObjectMapper();
        String content = result.getResponse().getContentAsString();
        List<Double> results = mapper.readValue(content, new TypeReference<>() {
        });
        assertEquals(3, results.size());

        verify(calculatorServiceMock, times(3)).calculate(anyInt(), anyInt(), any());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
