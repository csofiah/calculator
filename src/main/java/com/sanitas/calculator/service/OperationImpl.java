package com.sanitas.calculator.service;

import com.sanitas.calculator.model.OperationModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OperationImpl implements Operation{

    @Override
    public OperationModel add(OperationModel operationModel) {

            return operationModel.toBuilder()
                    .result(operationModel.getNumber1() + operationModel.getNumber2())
                    .build();


    }

    @Override
    public OperationModel substract(OperationModel operationModel) {
        try {
            return operationModel.toBuilder()
                    .result(operationModel.getNumber1() - operationModel.getNumber2())
                    .build();

        } catch (Exception ex) {
            return null;
        }
    }

}
