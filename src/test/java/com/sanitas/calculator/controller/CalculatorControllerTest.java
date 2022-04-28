package com.sanitas.calculator.controller;

import com.sanitas.calculator.mocks.OperationModelMocks;
import com.sanitas.calculator.model.OperationModel;
import com.sanitas.calculator.service.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorControllerTest {

    private CalculatorController underTest;
    private Operation operation;

    @BeforeEach
    void setUp() {
        operation = Mockito.mock(Operation.class);
        underTest = new CalculatorController(operation);

    }

    @DisplayName("add operation successful when OperationModel has 2 numbers with decimals")
    @Test
    void addWhenOperationModelHasTwoNumbersWithDecimalIsSuccessful() {
        OperationModel operationModelWithoutDecimals= OperationModelMocks.getOperationModelWith2NumbersWithDecimal();
        OperationModel opExpected = operationModelWithoutDecimals.toBuilder()
                .result(3d)
                .build();

        when(operation.add(operationModelWithoutDecimals)).thenReturn(opExpected);
        var result = underTest.add(operationModelWithoutDecimals);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).add(operationModelWithoutDecimals);
    }

    @DisplayName("add operation successful when OperationModel has 2 numbers with decimals")
    @Test
    void addWhenOperationModelHasTwoDecimalNumbersIsSuccessfulTest() {
        OperationModel operationModelWithDecimals= OperationModelMocks.getOperationModelWith2NumbersWithDecimal();
        OperationModel opExpected = operationModelWithDecimals.toBuilder()
                .result(3d)
                .build();
        when(operation.add(operationModelWithDecimals)).thenReturn(opExpected);
        var result = underTest.add(operationModelWithDecimals);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).add(operationModelWithDecimals);
    }

    @DisplayName("add operation successful when OperationModel has one number equal zero")
    @Test
    void addWhenOperationModelHasOneNumberEqualZeroIsSuccessfulTest() {
        OperationModel operationModelWithNumberZero= OperationModelMocks.getOperationModelWith1NumberZero();
        OperationModel opExpected = operationModelWithNumberZero.toBuilder()
                .result(3d)
                .build();
        when(operation.add(operationModelWithNumberZero)).thenReturn(opExpected);
        var result = underTest.add(operationModelWithNumberZero);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).add(operationModelWithNumberZero);
    }

    @DisplayName("add when the operation throw an exception")
    @Test
    void addWhenThrowException(){

        OperationModel operationModelWithHasZero= OperationModelMocks.getOperationModelWith1NumberZero();
        OperationModel result = null;
        try{
            when(operation.add(operationModelWithHasZero)).thenThrow(ResponseStatusException.class);
            result = underTest.add(operationModelWithHasZero);
            fail("Expected exception");
        }catch(ResponseStatusException e){
            assertEquals("500 INTERNAL_SERVER_ERROR \"Error del servidor\"", e.getMessage());
        }
        assertNull(result);
        verify(operation, times(1)).add(operationModelWithHasZero);
    }

    @DisplayName("subtract operation successful when With First Number Greater Than Second Number")
    @Test
    void subtractWithFirstNumberGreaterThanSecondNumberIsSuccessfulTest() {
        OperationModel operationModelWithFirstNumberGreaterThanSecondNumber= OperationModelMocks.getOperationModelWithFirstNumberGreaterThanSecondNumber();
        OperationModel opExpected = operationModelWithFirstNumberGreaterThanSecondNumber.toBuilder()
                .result(10d)
                .build();
        when(operation.subtract(operationModelWithFirstNumberGreaterThanSecondNumber)).thenReturn(opExpected);
        var result = underTest.subtract(operationModelWithFirstNumberGreaterThanSecondNumber);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).subtract(operationModelWithFirstNumberGreaterThanSecondNumber);
    }

    @DisplayName("subtract operation successful when With First Number is less Than Second Number")
    @Test
    void subtractWithFirstNumberIsLessThanSecondNumberIsSuccessfulTest() {
        OperationModel operationModelWithFirstNumberIsLessThanSecondNumber= OperationModelMocks.getOperationModelWithFirstNumberIsLessThanSecondNumber();

        OperationModel opExpected = operationModelWithFirstNumberIsLessThanSecondNumber.toBuilder()
                .result(10d)
                .build();
        when(operation.subtract(operationModelWithFirstNumberIsLessThanSecondNumber)).thenReturn(opExpected);
        var result = underTest.subtract(operationModelWithFirstNumberIsLessThanSecondNumber);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).subtract(operationModelWithFirstNumberIsLessThanSecondNumber);
    }

    @DisplayName("subtract operation successful when With First Number is less Than Second Number")
    @Test
    void subtractWhenOperationModelHasZeroIsSuccessfulTest() {
        OperationModel operationModelWithHasZero= OperationModelMocks.getOperationModelWith1NumberZero();

        OperationModel opExpected = operationModelWithHasZero.toBuilder()
                .result(5d)
                .build();
        when(operation.subtract(operationModelWithHasZero)).thenReturn(opExpected);
        var result = underTest.subtract(operationModelWithHasZero);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).subtract(operationModelWithHasZero);
    }

    @DisplayName("subtract when the operation throw an exception")
    @Test
    void subtractWhenThrowException(){

        OperationModel operationModelWithHasZero= OperationModelMocks.getOperationModelWith1NumberZero();
        OperationModel result = null;
        try{
            when(operation.subtract(operationModelWithHasZero)).thenThrow(ResponseStatusException.class);
            result = underTest.subtract(operationModelWithHasZero);
            fail("Expected exception");
        }catch(ResponseStatusException e){
            assertEquals("500 INTERNAL_SERVER_ERROR \"Error del servidor\"", e.getMessage());
        }
        assertNull(result);
        verify(operation, times(1)).subtract(operationModelWithHasZero);
    }

}