package com.sanitas.calculator.mocks;

import com.sanitas.calculator.model.OperationModel;

public class OperationModelMocks {

    public static OperationModel getOperationModelWith2NumberWithoutDecimal(){
        return  OperationModel.builder()
                .number1(1d)
                .number2(2d)
                .build();
    }

    public static OperationModel getOperationModelWith2NumberWithDecimal(){
        return  OperationModel.builder()
                .number1(1.5d)
                .number2(1.5d)
                .build();
    }

    public static OperationModel getOperationModelWith1NumberZero(){
        return  OperationModel.builder()
                .number1(5d)
                .number2(0d)
                .build();
    }

    public static OperationModel getOperationModelWithFirstNumberGreaterThanSecondNumber(){
        return  OperationModel.builder()
                .number1(15d)
                .number2(5d)
                .build();
    }

}
