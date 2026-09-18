package com.ruan.sistema_produto_api.model;

import com.ruan.sistema_produto_api.enums.Categoria;
import com.ruan.sistema_produto_api.enums.Unidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String marca;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private BigDecimal preco;
    private Integer estoque;

    @Enumerated(EnumType.STRING)
    private Unidade unidade;

    private BigDecimal pesoQtd;

    @Column(unique = true, nullable = false)
    private String codigoBarras;

    private LocalDate validade;
    private Boolean ativo;
    private LocalDateTime dataCadastro;
}
