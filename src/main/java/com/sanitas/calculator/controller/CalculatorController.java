package com.sanitas.calculator.controller;

import com.sanitas.calculator.model.OperationModel;
import com.sanitas.calculator.service.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/calculator")
public class CalculatorController {

    private final Operation operation;

    @PostMapping(value = "/add")
    public OperationModel add(@RequestBody OperationModel operationModel) {
        try {
            return operation.add(operationModel);
        } catch (Exception ex) {
            log.error("Exception {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor");
        }
    }

    @PostMapping(value = "/subtract")
    public OperationModel subtract(@RequestBody OperationModel operationModel) {
        try {
            return operation.subtract(operationModel);
        } catch (Exception ex) {
            log.error("Exception {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor");
        }
    }
}
