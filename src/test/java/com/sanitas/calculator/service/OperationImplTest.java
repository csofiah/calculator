package com.sanitas.calculator.service;

import com.sanitas.calculator.mocks.OperationModelMocks;
import com.sanitas.calculator.model.OperationModel;
import io.corp.calculator.TracerAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doNothing;

class OperationImplTest {
    private OperationImpl underTest;
    private TracerAPI tracerAPI;
    OperationModel operationModel1, operationModelDecimals, operationModelZero;
    OperationModel operationModelEmpty, operationModelSubstract;

    @BeforeEach
    void setup() {

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

        operationModelSubstract = OperationModel.builder()
                .number1(15d)
                .number2(5d)
                .build();

        operationModelEmpty = OperationModel.builder().build();

        tracerAPI = Mockito.mock(TracerAPI.class);
        underTest = new OperationImpl(tracerAPI);

        doNothing().when(tracerAPI).trace(anyDouble());
    }

    @Test
    void addWhenOperationIsSuccessfulTest() {

        OperationModel opExpected = OperationModelMocks.getOperationModelWith2NumberWithoutDecimal().toBuilder()
                .result(3d)
                .build();

        var result = underTest.add(OperationModelMocks.getOperationModelWith2NumberWithoutDecimal());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @Test
    void addWhenOperationModelHasTwoDecimalNumbersIsSuccessfulTest() {
        OperationModel opExpected = operationModelDecimals.toBuilder()
                .result(3d)
                .build();
        var result = underTest.add(operationModelDecimals);

        assertEquals(opExpected.getResult(), result.getResult());

    }


    @Test
    void addWhenOperationModelHasZeroIsSuccessfulTest() {
        OperationModel opExpected = operationModelZero.toBuilder()
                .result(5d)
                .build();
        var result = underTest.add(operationModelZero);

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @Test
    void substractWhenOperationIsSuccessfulTest() {
        OperationModel opExpected = operationModel1.toBuilder()
                .result(-1d)
                .build();
        var result = underTest.substract(operationModel1);

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @Test
    void substractWhenNumberOneIsBiggerThanNumberTwoIsSuccessfulTest() {
        OperationModel opExpected = operationModelSubstract.toBuilder()
                .result(10d)
                .build();
        var result = underTest.substract(operationModelSubstract);

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @Test
    void substractWhenOperationModelHasZeroIsSuccessfulTest() {
        OperationModel opExpected = operationModelZero.toBuilder()
                .result(5d)
                .build();
        var result = underTest.substract(operationModelZero);

        assertEquals(opExpected.getResult(), result.getResult());

    }


}