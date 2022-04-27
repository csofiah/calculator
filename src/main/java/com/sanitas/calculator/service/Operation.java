package com.sanitas.calculator.service;

import com.sanitas.calculator.model.OperationModel;

public interface Operation {
    OperationModel add(OperationModel operationModel);
    OperationModel substract(OperationModel operationModel);
}
