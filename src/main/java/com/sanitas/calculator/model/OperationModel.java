package com.sanitas.calculator.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@Setter
public class OperationModel {

    private Double number1;
    private Double number2;
    private Double result;
}
