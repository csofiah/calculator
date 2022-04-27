package com.sanitas.calculator.controller;

import com.sanitas.calculator.exception.OperationException;
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

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/calculator")
public class CalculatorController {

    private final Operation addOperation;

    @PostMapping(value = "/add")
    public OperationModel add(@RequestBody OperationModel operationModel) {
        try {
            return addOperation.add(operationModel);
        } catch (Exception ex) {
            log.error("Exception {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor");
        }
    }

    @PostMapping(value = "/substract")
    public OperationModel substract(@RequestBody OperationModel operationModel) {
        try {
            return addOperation.substract(operationModel);
        } catch (Exception ex) {
            log.error("Exception {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor");
        }
    }
}
