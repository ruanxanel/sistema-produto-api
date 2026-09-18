package com.ruan.sistema_produto_api.exception;

public class EstoqueInvalidoException extends RuntimeException {
    public EstoqueInvalidoException(String message) {
        super(message);
    }
}
