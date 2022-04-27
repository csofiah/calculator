package com.sanitas.calculator.exception;

public class OperationException extends RuntimeException {

    public enum Type{
        ERROR_OPERATION_ADD("Error al realizar la operacion de suma"),
        ERROR_OPERATION_SUBSTRACT("Error al realizar la operacion de resta");

        private final String message;

        Type(String message) {
            this.message = message;
        }

        public OperationException build(Throwable throwable) {

            return new OperationException(throwable, this);
        }
        public OperationException build() {
            return new OperationException(this);
        }


    }

    private final OperationException.Type type;

    public OperationException(OperationException.Type type) {
        super(type.message);
        this.type = type;
    }

    public OperationException(Throwable cause, OperationException.Type type) {
        super(type.message,cause);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

