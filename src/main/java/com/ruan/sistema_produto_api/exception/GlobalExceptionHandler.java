package com.ruan.sistema_produto_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ruan.sistema_produto_api.dto.ErrorResponse;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstoqueInsuficienteException.class)
    public ResponseEntity<ErrorResponse> handleEstoqueInsuficiente(
            EstoqueInsuficienteException e) {

        ErrorResponse response = new ErrorResponse(
                409,
                "Estoque insuficiente",
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler(EstoqueInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleEstoqueInvalido(
            EstoqueInvalidoException e) {

        ErrorResponse response = new ErrorResponse(
                400,
                "Estoque inválido",
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(PrecoInvalidoException.class)
    public ResponseEntity<ErrorResponse> handlePrecoInvalido(
            PrecoInvalidoException e) {
        ErrorResponse response = new ErrorResponse(
                400,
                "Preço inválido",
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(ProdutoJaCadastradoException.class)
    public ResponseEntity<ErrorResponse> handleProdutoJaCadastrado(
            ProdutoJaCadastradoException e) {
        ErrorResponse response = new ErrorResponse(
                409,
                "Produto já cadastrado",
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleProdutoNaoEncontrado(
            ProdutoNaoEncontradoException e) {

        ErrorResponse response = new ErrorResponse(
                404,
                "Produto não encontrado",
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}