package com.ruan.sistema_produto_api.dto;

import com.ruan.sistema_produto_api.enums.Categoria;
import com.ruan.sistema_produto_api.enums.Unidade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String nome;
    private String decricao;
    private String marca;
    private Categoria categoria;
    private BigDecimal preco;
    private Integer estoque;
    private Unidade unidade;
    private BigDecimal pesoQtd;
    private String codigoBarras;
    private LocalDate validade;
    private Boolean ativo;
    private LocalDateTime dataCadastro;
}
