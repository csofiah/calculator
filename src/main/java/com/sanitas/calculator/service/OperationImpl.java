package com.sanitas.calculator.service;

import com.sanitas.calculator.model.OperationModel;
import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class OperationImpl implements Operation {

    @Autowired
    private TracerImpl tracerAPI;


    @Override
    public OperationModel add(OperationModel operationModel) {

        var result = operationModel.getNumber1() + operationModel.getNumber2();
        tracerAPI.trace(result);

        return operationModel.toBuilder()
                .result(result)
                .build();

    }

    @Override
    public OperationModel subtract(OperationModel operationModel) {
        var result = operationModel.getNumber1() - operationModel.getNumber2();
        tracerAPI.trace(result);

        return operationModel.toBuilder()
                .result(result)
                .build();


    }

}
