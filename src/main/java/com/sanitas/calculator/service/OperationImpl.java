package com.sanitas.calculator.service;

import com.sanitas.calculator.exception.OperationException;
import com.sanitas.calculator.model.OperationModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OperationImpl implements Operation{

    @Override
    public OperationModel add(OperationModel operationModel) {
        try {
            return operationModel.toBuilder()
                    .result(operationModel.getNumber1() + operationModel.getNumber2())
                    .build();
        } catch (Exception ex) {
           throw OperationException.Type.ERROR_OPERATION_ADD.build(ex);
        }

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
