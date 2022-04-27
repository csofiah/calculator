package com.sanitas.calculator.service;

import com.sanitas.calculator.model.OperationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationImplTest {
    private OperationImpl underTest;
    OperationModel operationModel1, operationModelDecimals,operationModelZero;

    @BeforeEach
    void setup(){
          operationModel1 = OperationModel.builder()
                  .number1(1d)
                  .number2(2d)
                  .build();

        operationModelDecimals = OperationModel.builder()
                .number1(1.5d)
                .number2(1.5d)
                .build();

        operationModelZero = OperationModel.builder()
                .number1(0d)
                .number2(5d)
                .build();

          underTest = new OperationImpl();
    }

   @Test
    void addWhenOperationIsSuccessfulTest(){
        OperationModel opExpected = operationModel1.toBuilder()
                .result(3d)
                .build();
       var result = underTest.add(operationModel1);

       assertEquals(opExpected.getResult(), result.getResult());

   }

    @Test
    void addWhenOperationModelHasTwoDecimalNumbersIsSuccessfulTest(){
        OperationModel opExpected = operationModelDecimals.toBuilder()
                .result(3d)
                .build();
        var result = underTest.add(operationModelDecimals);

        assertEquals(opExpected.getResult(), result.getResult());

    }


    @Test
    void addWhenOperationModelHasZeroIsSuccessfulTest(){
        OperationModel opExpected = operationModelZero.toBuilder()
                .result(5d)
                .build();
        var result = underTest.add(operationModelZero);

        assertEquals(opExpected.getResult(), result.getResult());

    }



}