package com.sanitas.calculator.service;

import com.sanitas.calculator.model.OperationModel;
import io.corp.calculator.TracerAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OperationImpl implements Operation {

    @Qualifier("TracerAPIImpl")
    private final TracerAPIImpl tracerAPI;


    @Override
    public OperationModel add(OperationModel operationModel) {

        var result = operationModel.getNumber1() + operationModel.getNumber2();
        tracerAPI.trace(result);

        return operationModel.toBuilder()
                .result(result)
                .build();

    }

    @Override
    public OperationModel substract(OperationModel operationModel) {
        var result = operationModel.getNumber1() - operationModel.getNumber2();
        tracerAPI.trace(result);

        return operationModel.toBuilder()
                .result(result)
                .build();


    }

}
