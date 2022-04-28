package com.sanitas.calculator.service;

import com.sanitas.calculator.mocks.OperationModelMocks;
import com.sanitas.calculator.model.OperationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doNothing;

class OperationImplTest {
    private OperationImpl underTest;
    private TracerAPIImpl tracerAPI;
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

        tracerAPI = Mockito.mock(TracerAPIImpl.class);
        underTest = new OperationImpl(tracerAPI);

        doNothing().when(tracerAPI).trace(anyDouble());
    }

    @DisplayName("add operation successful when OperationModel has 2 Numbers Without Decimal")
    @Test
    void addWithOperationModelHas2NumberWithoutDecimalSuccessfulTest() {

        OperationModel opExpected = OperationModelMocks.getOperationModelHas2NumberWithoutDecimal().toBuilder()
                .result(3d)
                .build();

        var result = underTest.add(OperationModelMocks.getOperationModelHas2NumberWithoutDecimal());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when OperationModel has 2 Numbers With Decimals")
    @Test
    void addWhenOperationModelHasTwoNumbersWithDecimalSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWith2NumbersWithDecimal().toBuilder()
                .result(3d)
                .build();
        var result = underTest.add(OperationModelMocks.getOperationModelWith2NumbersWithDecimal());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when OperationModel has 2 Numbers With Decimals")
    @Test
    void addWhenOperationModelHasOneNumberEqualZeroIsSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWith1NumberZero().toBuilder()
                .result(5d)
                .build();
        var result = underTest.add(operationModelZero);

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when OperationModel has 2 Numbers With Decimals")
    @Test
    void substractWhenOperationIsSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWithFirstNumberGreaterThanSecondNumber().toBuilder()
                .result(-1d)
                .build();
        var result = underTest.substract(OperationModelMocks.getOperationModelWithFirstNumberGreaterThanSecondNumber());

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