package com.sanitas.calculator.controller;

import com.sanitas.calculator.model.OperationModel;
import com.sanitas.calculator.service.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CalculatorControllerTest {

    private CalculatorController underTest;
    private Operation operation;
    OperationModel operationModel1, operationModelDecimals, operationModelZero;
    OperationModel operationModelEmpty, operationModelSubstract;

    @BeforeEach
    void setUp() {
        operation = Mockito.mock(Operation.class);
        underTest = new CalculatorController(operation);

        operationModel1 = OperationModel.builder()
                .number1(1d)
                .number2(2d)
                .build();
        operationModelDecimals = OperationModel.builder()
                .number1(1.5d)
                .number2(1.5d)
                .build();

        operationModelZero = OperationModel.builder()
                .number1(5d)
                .number2(0d)
                .build();
        operationModelEmpty = OperationModel.builder().build();

        operationModelSubstract = OperationModel.builder()
                .number1(15d)
                .number2(5d)
                .build();
    }

    @Test
    void addWhenOperationIsSuccessful() {
        OperationModel opExpected = operationModel1.toBuilder()
                .result(3d)
                .build();

        when(operation.add(operationModel1)).thenReturn(opExpected);
        var result = underTest.add(operationModel1);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).add(operationModel1);
    }

    @Test
    void addWhenOperationModelHasTwoDecimalNumbersIsSuccessfulTest() {
        OperationModel opExpected = operationModelDecimals.toBuilder()
                .result(3d)
                .build();
        when(operation.add(operationModelDecimals)).thenReturn(opExpected);
        var result = underTest.add(operationModelDecimals);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).add(operationModelDecimals);
    }

    @Test
    void addWhenOperationModelIsEmptySuccessfulTest() {
        OperationModel opExpected = operationModelDecimals.toBuilder()
                .result(0d)
                .build();
        when(operation.add(operationModelEmpty)).thenReturn(opExpected);
        var result = underTest.add(operationModelEmpty);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).add(operationModelEmpty);
    }


    @Test
    void substractWhenOperationIsSuccessful() {
        OperationModel opExpected = operationModel1.toBuilder()
                .result(-1d)
                .build();

        when(operation.substract(operationModel1)).thenReturn(opExpected);
        var result = underTest.substract(operationModel1);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).substract(operationModel1);
    }

    @Test
    void substractWhenNumberOneIsBiggerThanNumberTwoIsSuccessfulTest() {
        OperationModel opExpected = operationModelSubstract.toBuilder()
                .result(10d)
                .build();
        when(operation.substract(operationModelSubstract)).thenReturn(opExpected);
        var result = underTest.substract(operationModelSubstract);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).substract(operationModelSubstract);
    }

    @Test
    void substractWhenOperationModelHasZeroIsSuccessfulTest() {
        OperationModel opExpected = operationModelZero.toBuilder()
                .result(5d)
                .build();
        when(operation.substract(operationModelZero)).thenReturn(opExpected);
        var result = underTest.substract(operationModelZero);

        assertEquals(opExpected.getResult(), result.getResult());
        verify(operation, times(1)).substract(operationModelZero);
    }

}