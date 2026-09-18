package com.ruan.sistema_produto_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String erro;
    private String mensagem;
    private LocalDateTime timestamp;
}
