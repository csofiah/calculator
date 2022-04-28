package com.sanitas.calculator.service;

import com.sanitas.calculator.mocks.OperationModelMocks;
import com.sanitas.calculator.model.OperationModel;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doNothing;


class OperationImplTest {

    @InjectMocks
    private OperationImpl underTest;

    @Mock
    private TracerImpl tracerAPI;

    @BeforeEach
    void setup() {

        MockitoAnnotations.openMocks(this);
        doNothing().when(tracerAPI).trace(anyDouble());
    }

    @DisplayName("add operation successful when OperationModel has 2 numbers without decimal")
    @Test
    void addWithOperationModelHas2NumberWithoutDecimalSuccessfulTest() {

        OperationModel opExpected = OperationModelMocks.getOperationModelHas2NumberWithoutDecimal().toBuilder()
                .result(3d)
                .build();

        var result = underTest.add(OperationModelMocks.getOperationModelHas2NumberWithoutDecimal());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when OperationModel has 2 numbers with decimals")
    @Test
    void addWhenOperationModelHasTwoNumbersWithDecimalSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWith2NumbersWithDecimal().toBuilder()
                .result(3d)
                .build();
        var result = underTest.add(OperationModelMocks.getOperationModelWith2NumbersWithDecimal());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when OperationModel has one number equal zero")
    @Test
    void addWhenOperationModelHasOneNumberEqualZeroIsSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWith1NumberZero().toBuilder()
                .result(5d)
                .build();
        var result = underTest.add(OperationModelMocks.getOperationModelWith1NumberZero());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when With First Number Greater Than Second Number")
    @Test
    void subtractWithFirstNumberGreaterThanSecondNumberIsSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWithFirstNumberGreaterThanSecondNumber().toBuilder()
                .result(10d)
                .build();
        var result = underTest.subtract(OperationModelMocks.getOperationModelWithFirstNumberGreaterThanSecondNumber());

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @DisplayName("add operation successful when With First Number is less Than Second Number")
    @Test
    void subtractWithFirstNumberIsLessThanSecondNumberIsSuccessfulTest() {
        OperationModel opExpected = OperationModelMocks.getOperationModelWithFirstNumberIsLessThanSecondNumber().toBuilder()
                .result(-5d)
                .build();
        var result = underTest.subtract(OperationModelMocks.getOperationModelWithFirstNumberIsLessThanSecondNumber());

        assertEquals(opExpected.getResult(), result.getResult());

    }


}