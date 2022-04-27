package com.sanitas.calculator.service;

import com.sanitas.calculator.exception.OperationException;
import com.sanitas.calculator.model.OperationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationImplTest {
    private OperationImpl underTest;
    OperationModel operationModel1, operationModelDecimals,operationModelZero;
    OperationModel operationModelEmpty,operationModelSubstract;

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
                .number1(5d)
                .number2(0d)
                .build();

        operationModelSubstract = OperationModel.builder()
                .number1(15d)
                .number2(5d)
                .build();

         operationModelEmpty = OperationModel.builder().build();

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

    @Test
    void substractWhenOperationIsSuccessfulTest(){
        OperationModel opExpected = operationModel1.toBuilder()
                .result(-1d)
                .build();
        var result = underTest.substract(operationModel1);

        assertEquals(opExpected.getResult(), result.getResult());

    }

    @Test
    void substractWhenNumberOneIsBiggerThanNumberTwoIsSuccessfulTest(){
        OperationModel opExpected = operationModelSubstract.toBuilder()
                .result(10d)
                .build();
        var result = underTest.substract(operationModelSubstract);

        assertEquals(opExpected.getResult(), result.getResult());

    }
    @Test
    void substractWhenOperationModelHasZeroIsSuccessfulTest(){
        OperationModel opExpected = operationModelZero.toBuilder()
                .result(5d)
                .build();
        var result = underTest.substract(operationModelZero);

        assertEquals(opExpected.getResult(), result.getResult());

    }



}